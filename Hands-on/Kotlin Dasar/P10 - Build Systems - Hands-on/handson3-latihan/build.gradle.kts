// Hands-on 3: Dependency Declaration
// Tugas: Latihan.kt di module ini butuh library "kotlinx-datetime" untuk
// mencetak tanggal hari ini, tapi library-nya BELUM dideklarasikan sebagai
// dependency di sini — makanya module ini belum bisa di-compile.
//
// TODO: Tambahkan blok dependencies {} di bawah ini yang mendeklarasikan
//   implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
//
// Setelah ditambahkan, Gradle akan resolve library tersebut dari
// mavenCentral() (sudah didefinisikan di root build.gradle.kts) dan
// menaruhnya di compile classpath module ini.

// dependencies {
//     implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
// }
