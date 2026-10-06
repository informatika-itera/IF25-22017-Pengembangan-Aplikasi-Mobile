# Hands-on Pertemuan 9 — Platform Specific Code & Dependency Injection

Proyek Kotlin Multiplatform (KMP) + Compose Multiplatform untuk 3 latihan praktikum Pertemuan 9 (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA), struktur sama seperti `P1 - Pengenalan MK dan Setup Environment - Hands-on/` (satu modul `composeApp` dengan `commonMain`/`androidMain`/`iosMain`/`desktopMain`).

Belum ada slide PDF untuk pertemuan ini — materi diturunkan langsung dari RPS Minggu 9 (Pertemuan 8 adalah UTS, jadi ini pertemuan pertama setelah UTS): *expect/actual Pattern, Platform APIs, Permissions, Dependency Injection dengan Koin*.

## Capaian Pembelajaran

- Menerapkan pola `expect`/`actual` untuk mengakses API native (getar perangkat)
- Memeriksa status permission platform (contoh: izin kamera) secara multiplatform-aware
- Menerapkan Dependency Injection dengan Koin di proyek Kotlin Multiplatform
- Memahami keterbatasan sharing kode 100% — beberapa fitur tetap butuh implementasi khusus per platform

## Cara Menjalankan

1. Pastikan Android Studio + Kotlin Multiplatform plugin sudah terinstall (lihat `P1 - Pengenalan MK dan Setup Environment - Hands-on/README.md` jika belum pernah setup).
2. Buka folder **"P9 - Platform Specific Features - Hands-on"** ini di Android Studio (`File > Open`) sebagai proyek terpisah, tunggu Gradle sync selesai.
3. Pilih salah satu run configuration:
   - **Android** — pilih configuration `composeApp`, pilih emulator/device, klik ▶️ (atau `./gradlew :composeApp:installDebug`). Uji Latihan 1 (getar) & Latihan 2 (izin kamera) di sini — keduanya butuh runtime Android untuk terasa nyata.
   - **Desktop** — `./gradlew :composeApp:run`. Latihan 1 akan mencetak log "tidak mendukung getar" ke console (bukan bug — memang begitu perilaku desktop), Latihan 2 selalu menunjukkan izin "DIBERIKAN" (stub).
   - **iOS** *(khusus Mac + Xcode)* — folder `iosApp/` tidak disertakan (lihat caveat yang sama di `P1 - Pengenalan MK dan Setup Environment - Hands-on/README.md`). Salin `composeApp/src/` dari sini ke proyek KMP baru dari [kmp.jetbrains.com](https://kmp.jetbrains.com) jika ingin mencoba di iOS.
4. Buka menu di `App.kt` untuk berpindah antar Latihan 1-3 dan Solusi 1-3.
5. Lengkapi TODO di `composeApp/src/commonMain/kotlin/.../latihan/`, lalu jalankan ulang.

## Daftar Latihan

### 1. `Handson1Vibrate.kt` — expect/actual Lanjutan: Getar Perangkat
`vibrate()` sudah diimplementasikan penuh lewat expect/actual (Android: `Vibrator`/`VibratorManager`; iOS: `UIImpactFeedbackGenerator`; Desktop: no-op). Tugasmu hanya memanggilnya dari tombol.

- **Konsep:** `expect`/`actual` untuk API native yang benar-benar berbeda per platform (bukan cuma string seperti di Pertemuan 1).
- **Simplifikasi:** Context Android diakses lewat `AndroidAppContext` (object global sederhana di-set dari `MainActivity`), bukan lewat DI — supaya contoh tetap fokus ke expect/actual. Pada aplikasi produksi sebaiknya pakai `Koin androidContext()` atau `expect class` dengan constructor injection.

### 2. `Handson2Permission.kt` — Permission Check (Platform-Aware)
`hasCameraPermission()` memeriksa **izin asli** di Android (`ContextCompat.checkSelfPermission`), tapi hanya stub `true` di iOS/Desktop.

- **Konsep:** Perbedaan model permission antar platform — Android punya runtime permission yang eksplisit, sementara contoh ini menyederhanakan iOS/Desktop.
- **Catatan:** Tombol "Simulasikan Minta Izin" sengaja tidak memanggil API request permission asli (`ActivityResultContracts`) supaya tetap sederhana.

### 3. `Handson3Di.kt` — Dependency Injection dengan Koin
`initKoin()` dan `appModule` (mendaftarkan `GreetingRepository`) sudah disiapkan di `di/AppModule.kt` dan dipanggil dari setiap entry point platform. Tugasmu: ambil instance lewat `koinInject<GreetingRepository>()` dan tampilkan hasilnya.

- **Konsep:** `module { single<T> { ... } }`, `startKoin`, `koinInject()` di Compose.
- **Catatan implementasi:** berbeda dari pola "sengaja tidak bisa di-compile" di hands-on lain — di sini latihan yang belum selesai tetap **bisa di-compile** (hanya menampilkan teks placeholder), karena proyek KMP ini satu modul `composeApp` tunggal: kalau satu file gagal compile, seluruh app (termasuk menu dan solusi lain) ikut gagal.

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| `NoBeanDefFoundException` / crash saat `koinInject()` | `koinInject()` dipanggil sebelum `initKoin()` dijalankan | Pastikan `initKoin()` dipanggil di `MainActivity`/`MainViewController`/`main.kt` **sebelum** `setContent`/`App()` |
| `KoinAppAlreadyStartedException` | `startKoin` dipanggil dua kali dalam satu proses (mis. Activity di-recreate) | Gunakan guard `if (GlobalContext.getOrNull() == null)` sebelum memanggil `initKoin()`, seperti di `MainActivity.kt` |
| Expect/actual mismatch (`... has no actual declaration ...`) | Signature fungsi `actual` tidak persis sama dengan `expect` di salah satu source set | Pastikan nama fungsi, parameter, dan return type `actual` identik dengan `expect fun` di `Platform.kt` |
| Aplikasi tidak bergetar di emulator Android | Beberapa emulator tidak mensimulasikan getar (haptics) | Uji di device fisik, atau anggap log/`Toast` sebagai bukti fungsi terpanggil |

## Sumber Pustaka

- [Kotlin Multiplatform — Expect/Actual Declarations](https://kotlinlang.org/docs/multiplatform-expect-actual.html)
- [Koin — Kotlin Multiplatform](https://insert-koin.io/docs/reference/koin-mp/kmp)
- [Koin — Compose Multiplatform](https://insert-koin.io/docs/reference/koin-compose/compose)
