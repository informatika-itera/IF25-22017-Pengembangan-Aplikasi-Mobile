# Hands-on Pertemuan 3 — Compose Multiplatform Basics

Proyek Kotlin Multiplatform (KMP) + Compose Multiplatform untuk 3 latihan praktikum Pertemuan 3 (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA).

Sama seperti `P1 - Pengenalan MK dan Setup Environment - Hands-on/`, ini adalah proyek KMP sungguhan: satu modul `composeApp` dengan source set `commonMain`, `androidMain`, `iosMain`, dan `desktopMain`. Ketiga latihan di bawah diambil langsung dari slide `P3 - Compose Multiplatform Basics.pdf` (halaman 30-32), yang sudah menyediakan template code dan expected result-nya.

## Capaian Pembelajaran

- Memahami paradigma UI deklaratif pada Compose Multiplatform
- Membuat dan menggunakan Composable functions (dengan parameter wajib, default, nullable, dan callback lambda)
- Menerapkan layout dasar: `Column`, `Row`, dan `Box`
- Menggunakan `Modifier` untuk styling dan positioning (termasuk memahami bahwa urutan modifier berpengaruh)
- Mengimplementasikan komponen UI: `Text`, `Button`, `Card`, `OutlinedTextField`, `Icon`

## Cara Menjalankan

1. Buka folder **"P3 - Compose Multiplatform Basics - Hands-on"** ini di Android Studio (`File > Open`) sebagai proyek terpisah, lalu tunggu Gradle sync selesai.
2. Pilih salah satu run configuration:
   - **Android** — pilih configuration `composeApp`, pilih emulator/device, klik ▶️ (atau `./gradlew :composeApp:installDebug`).
   - **Desktop** — jalankan `./gradlew :composeApp:run` dari terminal (paling cepat untuk coba-coba tanpa emulator).
   - **iOS** *(khusus Mac + Xcode)* — proyek ini **tidak menyertakan** folder `iosApp/` (proyek Xcode), sama seperti P1. Buat proyek baru lewat [kmp.jetbrains.com](https://kmp.jetbrains.com), lalu salin isi `composeApp/src/` dari folder ini.
3. Di `App.kt`, gunakan menu untuk berpindah antara Latihan 1-3 dan Solusi 1-3 (menu berbasis state sederhana, bukan Navigation Component — itu materi Pertemuan 5).
4. Buka file di `composeApp/src/commonMain/kotlin/.../latihan/`, lengkapi bagian `TODO`, lalu jalankan ulang untuk melihat hasilnya.

## Daftar Latihan

### 1. `Handson1ProfileCard.kt` — ProfileCard
Buat komponen `ProfileCard(name, bio)` dengan avatar bulat, nama (bold), dan bio (abu-abu), dibungkus `Card` dengan elevation.

- **Konsep:** `Card`, `CardDefaults.cardElevation()`, `Row` + `verticalAlignment`, `Box` dengan `contentAlignment` sebagai avatar placeholder.

### 2. `Handson2LoginForm.kt` — Login Form
Buat `LoginForm(onLogin)` dengan field username, field password (tersembunyi), dan tombol Login yang memanggil callback `onLogin(username, password)`.

- **Konsep:** `OutlinedTextField`, `PasswordVisualTransformation`, state (`remember`/`mutableStateOf`), callback lambda sebagai parameter Composable.

### 3. `Handson3ProductList.kt` — Product List
Lengkapi `ProdukItem(produk)` agar menampilkan kotak warna (pengganti gambar produk), nama, dan harga di dalam `Card` + `Row`, lalu ditampilkan berulang untuk `daftarProdukContoh`.

- **Konsep:** `data class`, `Card` + `Row` + `Column` bersarang, iterasi list dengan `forEach` (pengantar sebelum `LazyColumn` untuk list yang sangat panjang).

## Troubleshooting

Diambil dari slide P3 hal. 33, plus tambahan untuk hands-on ini:

| Error | Penyebab | Solusi |
|---|---|---|
| `@Composable invocations can only happen from the context of a @Composable function` | Memanggil fungsi `@Composable` dari fungsi biasa | Pastikan pemanggil juga dianotasi `@Composable` |
| `Unresolved reference: dp` / `sp` | Import belum ditambahkan | `import androidx.compose.ui.unit.dp` (atau `.sp`) |
| `Type mismatch: expected Color` | Menggunakan `Color` dari package yang salah | Gunakan `androidx.compose.ui.graphics.Color`, bukan `java.awt.Color` atau lainnya |
| `Unresolved reference: Icons` | Import icon belum lengkap | `import androidx.compose.material.icons.Icons` dan `import androidx.compose.material.icons.filled.Person` |

## Catatan: Tugas Praktikum Minggu 3 (terpisah dari hands-on ini)

Ada **Tugas Praktikum Minggu 3** (bobot 4%, deadline sebelum Pertemuan 4): buat aplikasi "My Profile App" dengan halaman profil (header foto+nama, bio, list info Email/Phone/Location), minimal 3 Composable function yang reusable, menggunakan minimal `Column`, `Row`, `Box`, `Card`, `Text`, `Button`, `Image`/`Icon`. Push ke repository GitHub yang sama dengan tugas Minggu 1. Lihat slide `P3 - Compose Multiplatform Basics.pdf` halaman 35-36 untuk rubrik penilaian lengkap (termasuk bonus +10% untuk animasi `AnimatedVisibility`).

## Sumber Pustaka

- [Compose Multiplatform Layout Documentation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-layout-basics.html)
- [Jetpack Compose - Lists and Grids](https://developer.android.com/develop/ui/compose/lists)
- [Jetpack Compose - Modifiers](https://developer.android.com/develop/ui/compose/modifiers)
