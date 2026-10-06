# Hands-on Pertemuan 5 — Navigasi Antar Layar, Passing Data

Proyek Kotlin Multiplatform (KMP) + Compose Multiplatform untuk 3 latihan praktikum Pertemuan 5 (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA), dengan struktur yang sama seperti `P1 - Pengenalan MK dan Setup Environment - Hands-on/` (satu modul `composeApp` dengan `commonMain`/`androidMain`/`iosMain`/`desktopMain`).

Belum ada slide PDF untuk pertemuan ini — materi hands-on digali langsung dari RPS (Rencana Pembelajaran Semester) Minggu 5: *"Mahasiswa membuat aplikasi multi-screen dengan navigasi"*, Bahan Kajian: Navigation Component, NavHost, NavController, Arguments, Bottom Navigation, Drawer.

## Capaian Pembelajaran

- Menggunakan `NavHost` dan `NavController` untuk navigasi antar layar
- Mengirim data antar layar lewat route arguments (`navArgument`)
- Membuat Bottom Navigation multi-tab yang mempertahankan state tiap tab
- Memahami konsep back stack dan cara mengelolanya (`popBackStack`, `popUpTo`)

## Cara Menjalankan

1. Buka folder **"P5 - Navigasi Antar Layar - Hands-on"** ini di Android Studio (`File > Open`) sebagai proyek terpisah, lalu tunggu Gradle sync selesai.
2. Pilih salah satu run configuration:
   - **Android** — pilih configuration `composeApp`, pilih emulator/device, klik ▶️ (atau `./gradlew :composeApp:installDebug`).
   - **Desktop** — jalankan `./gradlew :composeApp:run` dari terminal.
   - **iOS** *(khusus Mac + Xcode)* — proyek ini tidak menyertakan folder `iosApp/` (proyek Xcode). Buat proyek baru lewat [kmp.jetbrains.com](https://kmp.jetbrains.com), lalu salin isi `composeApp/src/` dari folder ini ke proyek barumu.
3. Dari menu utama `App.kt`, pilih Latihan 1/2/3 atau Solusi 1/2/3. Menu luar ini pakai state sederhana (sama seperti pertemuan lain); yang menggunakan Navigation Component sungguhan adalah **di dalam** tiap latihan.
4. Buka file di `composeApp/src/commonMain/kotlin/.../latihan/`, lengkapi bagian `TODO`, lalu jalankan ulang untuk melihat hasilnya.

## Daftar Latihan

### 1. `Handson1NavHostDasar.kt` — NavHost & NavController Dasar
Hubungkan 2 layar ("home" dan "detail") dengan `NavHost` + `NavController`: tombol di Home memanggil `navController.navigate("detail")`, tombol di Detail memanggil `navController.popBackStack()`.

- **Konsep:** `rememberNavController()`, `NavHost`, `composable(route)`, `navigate()`, `popBackStack()`.

### 2. `Handson2PassingData.kt` — Passing Data via Arguments
Daftar item di Home, tap salah satu untuk membuka Detail dengan `itemId` yang benar, dikirim lewat route argument (`"detail/{itemId}"`).

- **Konsep:** `navArgument`, `NavType.IntType`, membaca `backStackEntry.arguments`.

### 3. `Handson3BottomNavigation.kt` — Bottom Navigation
3 tab (Home/Search/Profil) dengan `NavigationBar` + `NavigationBarItem`, terhubung ke satu `NavHost`.

- **Catatan:** kode latihan ini **bisa dijalankan** tapi sengaja punya bug — `navigate()` dipanggil tanpa opsi `popUpTo`/`launchSingleTop`/`restoreState`, sehingga back stack menumpuk setiap kali pindah tab. Coba dulu, amati bug-nya, baru perbaiki lewat TODO.
- **Konsep:** `NavigationBar`, `currentBackStackEntryAsState()`, `popUpTo` + `saveState`, `launchSingleTop`, `restoreState`.

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| `IllegalArgumentException: Navigation destination that matches route ... cannot be found` | Route yang dipanggil di `navigate()` tidak sama persis dengan yang didaftarkan di `composable(...)`, atau tipe argumen tidak cocok | Pastikan string route (termasuk placeholder `{itemId}`) sama persis, dan tipe `navArgument` sesuai nilai yang dikirim |
| Back stack menumpuk / tombol Back harus ditekan berkali-kali saat pindah tab | `navigate()` dipanggil tanpa `popUpTo` | Tambahkan blok `popUpTo(startDestinationId) { saveState = true }` + `launchSingleTop = true` + `restoreState = true`, seperti di Handson3 |
| Data hilang saat kembali ke tab sebelumnya | Lupa `restoreState = true` pada `navigate()`, atau lupa `saveState = true` pada `popUpTo` | Pasangkan keduanya — salah satu saja tidak cukup |
| Gradle sync gagal resolve `org.jetbrains.androidx.navigation:navigation-compose` | Versi `navigationCompose` di `gradle/libs.versions.toml` (saat ini `2.8.0-alpha10`) mungkin sudah usang | Cek versi stabil terbaru di [Navigation Compose Multiplatform releases](https://maven.google.com) atau dokumentasi resmi, lalu update `libs.versions.toml` |

## Sumber Pustaka

- [Navigate with Compose (Android/AndroidX)](https://developer.android.com/develop/ui/compose/navigation)
- [Kotlin Multiplatform Documentation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [Compose Multiplatform Documentation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform.html)
