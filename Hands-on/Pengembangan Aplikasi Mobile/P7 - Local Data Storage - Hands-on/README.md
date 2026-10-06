# Hands-on Pertemuan 7 — Local Data Persistence

Proyek Kotlin Multiplatform (KMP) + Compose Multiplatform untuk 3 latihan praktikum Pertemuan 7 (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA). Sama seperti `P1 - Pengenalan MK dan Setup Environment - Hands-on/`, ini adalah proyek KMP sungguhan (bukan Kotlin/JVM biasa) dengan modul `composeApp`.

Belum ada slide untuk pertemuan ini — materi & latihan di sini diturunkan langsung dari RPS Minggu 7: **CPMK0501** — "Mahasiswa menyimpan data lokal dengan SQLDelight", Bahan Kajian: *DataStore Preferences, SQLDelight, Room (Android), Offline-First Architecture*.

## Capaian Pembelajaran

- Memahami mengapa aplikasi mobile perlu penyimpanan data lokal (offline-first)
- Menerapkan SQLDelight sebagai database SQL multiplatform (satu skema `.sq`, berjalan di Android/iOS/Desktop)
- Menerapkan pola `expect`/`actual` untuk `DatabaseDriverFactory` yang berbeda tiap platform
- Membaca data sebagai `Flow` yang otomatis update saat data berubah (via `sqldelight-coroutines`)
- Membangun UI CRUD sederhana (tambah, tampilkan, hapus) yang datanya persisten lintas restart aplikasi

## Cara Menjalankan

1. Buka folder **"P7 - Local Data Storage - Hands-on"** ini di Android Studio (`File > Open`) sebagai proyek terpisah, lalu tunggu Gradle sync selesai.
2. **Penting:** sync pertama akan men-generate kelas Kotlin `AppDatabase` dari file `.sq` di `composeApp/src/commonMain/sqldelight/`. Kalau `AppDatabase`/`Catatan`/`Preferensi` muncul "unresolved reference" di editor, coba re-sync Gradle atau jalankan `./gradlew :composeApp:generateCommonMainAppDatabaseInterface` secara manual.
3. Pilih salah satu run configuration:
   - **Android** — pilih configuration `composeApp`, pilih emulator/device, klik ▶️ (atau `./gradlew :composeApp:installDebug`).
   - **Desktop** — jalankan `./gradlew :composeApp:run` dari terminal (paling cepat untuk coba-coba tanpa emulator). Catatan: driver desktop di sini pakai SQLite **in-memory**, jadi data akan reset setiap kali proses desktop di-restart — ini keterbatasan starter project, bukan bug; untuk uji "data tetap ada setelah restart" yang sesungguhnya, uji di Android/iOS.
   - **iOS** *(khusus Mac + Xcode)* — proyek ini tidak menyertakan folder `iosApp/` (proyek Xcode). Buat proyek baru lewat [kmp.jetbrains.com](https://kmp.jetbrains.com), lalu salin isi `composeApp/src/` dari folder ini ke proyek barumu.
4. Di layar Menu (`App.kt`), pilih Latihan 1-3 atau Solusi 1-3.
5. Buka file di `composeApp/src/commonMain/kotlin/.../latihan/`, lengkapi bagian `TODO`, lalu jalankan ulang untuk melihat hasilnya.

## Daftar Latihan

### 1. `Handson1Preferensi.kt` — "DataStore Preferences Sederhana"
Simpan & tampilkan "jumlah aplikasi dibuka" yang persisten lintas restart.

- **Keputusan desain:** DataStore Preferences versi Multiplatform butuh setup `okio` + path provider tambahan per-platform yang berisiko salah tanpa bisa di-compile-check di lingkungan pembuatan hands-on ini. Sebagai gantinya, latihan ini mensimulasikan **konsep yang sama persis** (satu nilai key-value yang persisten) memakai tabel `Preferensi` pada database SQLDelight yang sama dengan Latihan 2-3. Pola read-modify-write-nya identik dengan cara kerja DataStore asli — kalau kelas ingin memakai DataStore Multiplatform sungguhan, ini titik yang tepat untuk menggantinya nanti.
- **Konsep:** persist key-value, `executeAsOneOrNull()`, `INSERT OR REPLACE` (upsert).

### 2. `Handson2Repository.kt` — SQLDelight Insert & Query
Lengkapi `CatatanRepository` (`getAll()`, `tambah()`, `hapus()`) yang membungkus query SQLDelight dari `Catatan.sq`.

- **Konsep:** `expect`/`actual DatabaseDriverFactory`, `AppDatabase` hasil code-gen, `Flow` dari `asFlow().mapToList(...)`.

### 3. `Handson3OfflineNotes.kt` — Offline-First: Tampilkan & Hapus Catatan
Pakai `CatatanRepository` dari Latihan 2 untuk menampilkan `LazyColumn` catatan + form tambah + tombol hapus.

- **Catatan:** layar ini sengaja hanya menampilkan placeholder sebelum semua TODO dilengkapi.
- **Konsep:** `collectAsState`, `LazyColumn`/`items`, offline-first (data tetap ada tanpa koneksi internet).

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| `Unresolved reference: AppDatabase` (atau `CatatanQueries`/`PreferensiQueries`) | Kode SQLDelight belum di-generate | Re-sync Gradle, atau jalankan `./gradlew :composeApp:generateCommonMainAppDatabaseInterface` |
| Data selalu kosong lagi setiap dibuka ulang di **Desktop** | Driver desktop di starter ini pakai `JdbcSqliteDriver.IN_MEMORY` (memang didesain begitu untuk starter sederhana) | Untuk persistensi sungguhan di desktop, ganti ke `JdbcSqliteDriver("jdbc:sqlite:catatan.db")` (file lokal) di `DatabaseDriverFactory.desktop.kt` |
| `[SQLITE_ERROR] no such table: Catatan` di Desktop | Lupa memanggil `AppDatabase.Schema.create(driver)` — beda dari `AndroidSqliteDriver`/`NativeSqliteDriver` yang otomatis membuat skema lewat parameter `schema` | Pastikan `DatabaseDriverFactory.desktop.kt` memanggil `AppDatabase.Schema.create(driver)` sebelum driver dipakai |
| `NotImplementedError: Lengkapi getAll()` saat membuka Latihan 3 | `CatatanRepository.getAll()` di Latihan 2 masih `TODO()` | Selesaikan dulu Latihan 2 sebelum mencoba Latihan 3 |

## Sumber Pustaka

- [SQLDelight Documentation](https://cashapp.github.io/sqldelight/)
- [Kotlin Multiplatform — Data Persistence Overview](https://www.jetbrains.com/help/kotlin-multiplatform-dev/data-persistence.html)
- [Kotlin Coroutines Flow](https://kotlinlang.org/docs/flow.html)
