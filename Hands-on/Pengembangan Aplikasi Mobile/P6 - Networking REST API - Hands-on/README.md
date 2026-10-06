# Hands-on Pertemuan 6 — Networking (Ktor Client & JSON)

Proyek Kotlin Multiplatform (KMP) + Compose Multiplatform untuk 3 latihan praktikum Pertemuan 6 (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA).

Proyek KMP sungguhan seperti `P1 - Pengenalan MK dan Setup Environment - Hands-on/` (modul `composeApp` dengan `commonMain`/`androidMain`/`iosMain`/`desktopMain`). **Belum ada slide PDF untuk pertemuan ini** — materi dan latihan diturunkan langsung dari RPS (Minggu 6: HTTP/REST, Ktor Client, JSON Serialization, Repository Pattern, Loading States).

## Capaian Pembelajaran

- Menggunakan Ktor Client untuk melakukan HTTP GET request dari kode Kotlin Multiplatform
- Men-decode response JSON menjadi data class dengan `kotlinx.serialization`
- Menerapkan Repository Pattern untuk memisahkan sumber data dari UI
- Merepresentasikan status pengambilan data (Loading/Success/Error) dengan `sealed class`
- Menampilkan data dari REST API di Compose dengan penanganan loading & error state

## Cara Menjalankan

1. Buka folder **"P6 - Networking REST API - Hands-on"** ini di Android Studio (`File > Open`), tunggu Gradle sync selesai.
2. Pilih salah satu run configuration:
   - **Android** — pilih configuration `composeApp`, pilih emulator/device, klik ▶️. **Perlu koneksi internet aktif di emulator/device** (izin `INTERNET` sudah ditambahkan di `AndroidManifest.xml`).
   - **Desktop** — jalankan `./gradlew :composeApp:run` dari terminal.
   - **iOS** *(khusus Mac + Xcode)* — sama seperti `P1 - Pengenalan MK dan Setup Environment - Hands-on/`, folder `iosApp/` tidak disertakan; buat proyek baru via [kmp.jetbrains.com](https://kmp.jetbrains.com) lalu salin isi `composeApp/src/` dari sini.
3. Di menu `App.kt`, pilih Latihan 1-3 atau Solusi 1-3.
4. Buka file di `composeApp/src/commonMain/kotlin/.../latihan/`, lengkapi bagian `TODO`, lalu jalankan ulang.

Seluruh latihan memanggil satu endpoint yang sama untuk konsistensi cerita: `https://jsonplaceholder.typicode.com/users` (fake REST API gratis, umum dipakai untuk belajar, tidak butuh API key).

## Daftar Latihan

### 1. `Handson1KtorClient.kt` — Ktor Client Dasar & GET Request
Lengkapi `HttpClient` dengan plugin `ContentNegotiation` + `json()`, lalu implementasikan `fetchUsers()` yang melakukan GET request dan men-decode hasilnya menjadi `List<RemoteUser>`.

- **Konsep:** `HttpClient`, `ContentNegotiation`, `@Serializable`, `suspend fun`.

### 2. `Handson2Repository.kt` — Repository Pattern & Loading State
Lengkapi `UserListStateHolder.load()` agar mengubah `_state` menjadi `Loading` → memanggil `UserRepository.getUsers()` → `Success`/`Error` tergantung hasilnya.

- **Konsep:** Repository Pattern, `sealed class` untuk UI state, `MutableStateFlow`/`StateFlow`.

### 3. `Handson3UserListUi.kt` — Loading/Error UI
Tampilkan `UiState` di Compose: `CircularProgressIndicator()` saat Loading, `LazyColumn` daftar user saat Success, pesan error + tombol "Coba Lagi" saat Error.

- **Catatan:** fungsi ini sengaja belum menampilkan apa-apa selain placeholder sebelum semua TODO dilengkapi.
- **Konsep:** `LaunchedEffect`, `collectAsState`, `rememberCoroutineScope`, smart-cast pada `sealed class`.

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| `SecurityException: Permission denied (missing INTERNET permission)` | Lupa menambahkan `<uses-permission android:name="android.permission.INTERNET" />` di `AndroidManifest.xml` (sudah ditambahkan di proyek ini — cek lagi kalau menyalin ke proyek lain) | Tambahkan permission tsb sebelum `<application>` |
| `IllegalStateException: no client engine found` (khususnya di Desktop/iOS) | Lupa menambahkan dependency engine Ktor spesifik platform (`ktor-client-cio` untuk Desktop, `ktor-client-darwin` untuk iOS, `ktor-client-android` untuk Android) | Pastikan setiap source set punya dependency engine yang sesuai (lihat `composeApp/build.gradle.kts`) |
| `SerializationException` saat decode JSON | Nama field di `@Serializable data class` tidak cocok dengan response API, atau API mengembalikan field tambahan | Cocokkan nama field, atau pakai `Json { ignoreUnknownKeys = true }` |
| UI tidak pernah keluar dari Loading | Lupa memanggil `holder.load()` di `LaunchedEffect(Unit) { ... }`, atau exception tertelan tanpa masuk ke state Error | Pastikan `load()` benar-benar dipanggil dan try-catch-nya lengkap |

## Sumber Pustaka

- [Ktor Client Documentation](https://ktor.io/docs/client-create-new-application.html)
- [kotlinx.serialization Documentation](https://github.com/Kotlin/kotlinx.serialization)
- [Kotlin Multiplatform Documentation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
