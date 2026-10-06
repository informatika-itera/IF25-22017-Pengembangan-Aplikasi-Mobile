# Hands-on Pertemuan 11 — Testing dan Dependency Injection

Proyek Kotlin Multiplatform (KMP) + Compose Multiplatform untuk 3 latihan praktikum Pertemuan 11 (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA), struktur sama seperti `P1 - Pengenalan MK dan Setup Environment - Hands-on/`.

Belum ada slide untuk pertemuan ini, jadi materi & latihan di sini diturunkan langsung dari RPS (Minggu 11, CPMK0502): *"Mahasiswa menulis test dan setup DI"* — Bahan Kajian: Unit Testing, UI Testing, Koin DI, Test Doubles, Debugging.

**Perbedaan penting dari pertemuan lain:** karena topiknya testing, latihan sungguhannya berupa **file test** (`@Test` di `composeApp/src/commonTest/`), bukan layar Compose. Layar-layar di `App.kt` hanya instruksional, mengarahkan ke file test yang harus dikerjakan.

## Capaian Pembelajaran

- Menulis unit test dengan `kotlin.test` mengikuti pola Arrange-Act-Assert
- Memahami dan membuat *test double* (fake) untuk dependency yang non-deterministik (waktu, network, dsb.)
- Menyusun dan memverifikasi modul dependency injection dengan Koin
- Memahami mengapa kode yang bergantung pada Koin/DI lebih mudah diuji dibanding kode yang membuat dependency-nya sendiri secara langsung

## Cara Menjalankan

1. Buka folder **"P11 - Testing dan DI - Hands-on"** ini di Android Studio (`File > Open`), tunggu Gradle sync selesai.
2. Untuk melihat layar instruksional (opsional): jalankan seperti biasa — **Android** (configuration `composeApp`) atau **Desktop** (`./gradlew :composeApp:run`).
3. Untuk mengerjakan latihan sungguhannya: buka file test di `composeApp/src/commonTest/kotlin/com/itera/pam/p11/latihan/`, lengkapi bagian `TODO`.
4. Jalankan test lewat IDE (klik ikon ▶️ di sebelah nama class/fungsi test) atau dari terminal: `./gradlew :composeApp:desktopTest` (menjalankan test commonTest lewat target desktop/JVM — paling cepat, tidak perlu emulator).
5. Bandingkan dengan versi lengkap di `composeApp/src/commonTest/kotlin/com/itera/pam/p11/solusi/` jika stuck.

## Daftar Latihan

### 1. `CounterTest.kt` — Unit Test Dasar (Arrange-Act-Assert)
Uji `Counter.increment()` / `decrement()` (minimum 0) / `reset()` menggunakan `kotlin.test.assertEquals`.

- **Konsep:** pola AAA (Arrange-Act-Assert), `kotlin.test`, unit test tanpa dependency eksternal.

### 2. `SessionLoggerTest.kt` — Test Double (Fake ClockProvider)
Lengkapi `FakeClockProvider` yang mendelegasikan ke `TestTimeSource` (jam palsu bawaan `kotlin.time`), lalu gunakan untuk menguji `SessionLogger` secara deterministik — tanpa test double, test berbasis waktu asli akan flaky.

- **Catatan:** class `FakeClockProvider` di file latihan sengaja tidak lengkap (tidak meng-implement `ClockProvider` sepenuhnya) sampai delegasi `TimeSource by source` ditambahkan — modul ini **tidak akan compile** sebelum TODO 1 selesai.
- **Konsep:** test double / fake, `TestTimeSource`, Kotlin interface delegation (`by`).

### 3. `KoinModuleTest.kt` — Koin DI Module
Verifikasi bahwa `appModule` (di `composeApp/src/commonMain/kotlin/.../di/AppModule.kt`) bisa di-resolve Koin dengan benar, menggunakan `KoinTest` + `by inject<T>()`.

- **Konsep:** Koin `module { }`, `startKoin`/`stopKoin`, `KoinTest`, dependency injection sebagai cara membuat kode mudah diuji.

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| Test lulus di lokal tapi kadang gagal di CI (flaky) | Test berbasis waktu asli (`TimeSource.Monotonic` sungguhan) yang hasilnya tidak presisi | Gunakan test double seperti `FakeClockProvider`/`TestTimeSource` (lihat Hands-on 2) |
| `KoinAppAlreadyStartedException` | `startKoin { }` dipanggil dua kali tanpa `stopKoin()` di antaranya (mis. antar test class) | Pastikan `stopKoin()` selalu dipanggil di `@AfterTest` |
| `NoBeanDefFoundException` / dependency `null` saat `inject()` | Modul yang berisi definisi dependency tsb belum didaftarkan lewat `modules(appModule)` | Pastikan `startKoin { modules(appModule) }` memuat semua modul yang dibutuhkan |
| Kode di `commonTest` tidak bisa memanggil API Android/iOS tertentu | `commonTest` hanya boleh memakai API yang tersedia di SEMUA platform | Pindahkan kode platform-specific ke `androidUnitTest`/`iosTest`, atau abstraksikan lewat `expect`/`actual` |

## Sumber Pustaka

- [kotlin.test Documentation](https://kotlinlang.org/api/latest/kotlin.test/)
- [Kotlin Multiplatform Testing](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-run-tests.html)
- [Koin — Testing](https://insert-koin.io/docs/reference/koin-test/testing)
