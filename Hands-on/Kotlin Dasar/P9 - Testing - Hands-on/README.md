# Hands-on Pertemuan 9 (Kotlin Dasar) — Testing

Proyek Kotlin/JVM untuk 3 latihan praktikum Pertemuan 9 track suplemen **Kotlin Dasar** (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA).

## Capaian Pembelajaran

- Menjelaskan tujuan dan prinsip dasar testing (testing membuktikan ADANYA bug, bukan ketiadaannya)
- Membedakan jenis-jenis testing (functional, load, stress, regression, dll.) dan level testing (unit, integration, system, acceptance)
- Menulis unit test dengan JUnit5 menggunakan pola Arrange-Act-Assert
- Menguji exception dengan `assertThrows`
- Menggunakan anotasi lifecycle (`@BeforeEach`) untuk menyiapkan fixture sebelum setiap test

## Cara Menjalankan

Modul di pertemuan ini berbeda dari pertemuan lain: kode yang diuji ada di `src/main/kotlin/`, sedangkan latihan (bagian ber-TODO) ada di `src/test/kotlin/`. Tidak ada `fun main()` untuk di-klik — kamu menjalankan **test**, bukan program.

1. Buka folder **"P9 - Testing - Hands-on"** ini di Android Studio (`File > Open`) sebagai proyek Gradle terpisah.
2. Tunggu proses Gradle sync selesai.
3. Buka file test (mis. `handson1-latihan/src/test/kotlin/CalculatorTest.kt`), lengkapi bagian `TODO`, lalu **hapus baris `fail(...)`** di test yang sudah kamu lengkapi.
4. Klik ikon ▶️ di sebelah nama class test (atau nama fungsi test) untuk menjalankannya, atau jalankan semua test dari terminal:
   ```
   ./gradlew :handson1-latihan:test
   ```
5. Jika stuck, bandingkan dengan file test di modul `-solusi` yang berpasangan.

Setiap latihan adalah modul Gradle terpisah, jadi latihan yang belum selesai (test-nya masih merah/gagal) **tidak akan mengganggu** latihan atau solusi lain.

## Daftar Latihan

### 1. `handson1-latihan` / `handson1-solusi` — Unit Test Dasar (Pola AAA)
Lengkapi test untuk class `Calculator` (`add`, `subtract`, `divide`) mengikuti pola **Arrange-Act-Assert**, menggunakan `assertEquals(expected, actual)`.

- **Konsep:** `@Test`, `@DisplayName`, `assertEquals`, pola AAA.

### 2. `handson2-latihan` / `handson2-solusi` — Testing Exception
Lengkapi test untuk class `BankAccount`. Fokus pada kasus `withdraw()` yang harus melempar `InsufficientFundsException` saat saldo tidak cukup.

- **Konsep:** `assertThrows<T> { ... }`, custom exception, exception testing.

### 3. `handson3-latihan` / `handson3-solusi` — Test Lifecycle & Setup
Lengkapi `@BeforeEach` pada `TodoListTest` supaya setiap test mendapat instance `TodoList` baru yang kosong, lalu lengkapi test `add`/`remove`/`isEmpty`.

- **Catatan:** semua test di modul ini **sengaja gagal (merah)** sebelum kamu melengkapi TODO — itu bagian dari latihan.
- **Konsep:** `@BeforeEach`, test isolation/fixture setup.

## Troubleshooting

| Error / Gejala | Penyebab | Solusi |
|---|---|---|
| Test tidak muncul/terdeteksi di panel Run | Lupa anotasi `@Test` di atas fungsi, atau fungsi bukan `fun` biasa (mis. `private`) | Pastikan setiap test method punya `@Test` dan tidak `private` |
| `AssertionFailedError: expected: <X> but was: <Y>` padahal logikanya benar | Urutan argumen `assertEquals` tertukar — argumen pertama harus **expected**, kedua **actual** | Tulis `assertEquals(expected, actual)`, bukan `assertEquals(actual, expected)` |
| Menjalankan `./gradlew test` tidak menjalankan test JUnit5 sama sekali (0 test dijalankan) | Task `Test` belum diset `useJUnitPlatform()` | Sudah dikonfigurasi di `build.gradle.kts` root (`tasks.withType<Test> { useJUnitPlatform() }`) — cek modulmu tidak meng-override konfigurasi ini |

## Sumber Pustaka

- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Kotlin — Test code using JUnit in JVM](https://kotlinlang.org/docs/jvm-test-using-junit.html)
- [kotlin.test API Reference](https://kotlinlang.org/api/latest/kotlin.test/)
