# Hands-on Pertemuan 8 (Kotlin Dasar) — Exceptions

Proyek Kotlin/JVM untuk 3 latihan praktikum Pertemuan 8 track suplemen **Kotlin Dasar** (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA).

## Capaian Pembelajaran

- Memahami apa itu exception dan kapan (tidak) menggunakannya
- Menangani error dengan `try` / `catch` / `finally`
- Membuat dan melempar exception kustom (custom exception hierarchy)
- Menggunakan gula sintaksis Kotlin untuk error handling: `try` sebagai expression, `require()`, dan `error()`

## Cara Menjalankan

1. Buka folder **"P8 - Exceptions - Hands-on"** ini di Android Studio / IntelliJ (`File > Open`) sebagai proyek Gradle terpisah.
2. Tunggu proses Gradle sync selesai.
3. Buka file `Latihan.kt` pada modul yang ingin dikerjakan, lengkapi bagian `TODO`.
4. Klik ikon ▶️ di sebelah `fun main()` untuk menjalankan.
5. Jika stuck, bandingkan dengan `Solusi.kt` pada modul `-solusi` yang berpasangan.

Setiap latihan adalah modul Gradle terpisah, jadi latihan yang belum selesai (belum bisa di-compile) **tidak akan mengganggu** latihan atau solusi lain.

## Daftar Latihan

### 1. `handson1-latihan` / `handson1-solusi` — Try-Catch-Finally Dasar
Lengkapi fungsi `safeDivide(a, b)` agar menangani `ArithmeticException` (pembagian dengan nol) tanpa membuat program crash, dan memastikan blok `finally` selalu tereksekusi.

- **Konsep:** `try`, `catch`, `finally`, `ArithmeticException`.

### 2. `handson2-latihan` / `handson2-solusi` — Custom Exception & Exception Hierarchy
Buat `class InsufficientBalanceException : Exception` untuk kasus saldo tidak cukup pada `BankAccount.withdraw()`, lalu tangani secara spesifik di pemanggilnya tanpa menghentikan program.

- **Konsep:** custom exception class, exception hierarchy (`Throwable` → `Exception`), `require()`.

### 3. `handson3-latihan` / `handson3-solusi` — Kotlin Sugar: try-expression, require(), error(), multi-catch
Implementasikan `parseTiket(input: String): Tiket` yang mem-parsing teks `"nama/umur"` menggunakan `try` sebagai *expression*, `require()` untuk validasi input, dan `error()` untuk kondisi yang seharusnya tidak terjadi, lalu tangani hasilnya dengan multi-catch di `main()`.

- **Catatan:** file `Latihan.kt` di modul ini **sengaja tidak bisa di-compile** sebelum kamu melengkapi TODO (ada pemanggilan `TODO(...)`) — itu bagian dari latihan.
- **Konsep:** `try` sebagai expression, `require()` → `IllegalArgumentException`, `error()` → `IllegalStateException`, multi-catch.

## Troubleshooting

| Error / Gejala | Penyebab | Solusi |
|---|---|---|
| Exception "hilang begitu saja" / bug sulit dilacak | Blok `catch` dibiarkan kosong (`catch (e: Exception) {}`) sehingga error ditelan diam-diam | Minimal `println`/log pesan error di setiap `catch`, jangan pernah biarkan blok catch kosong |
| Kode setelah `finally` tetap jalan padahal ada error | Lupa bahwa `finally` **selalu** dieksekusi (baik try sukses, gagal, atau ada `return`), tapi ia tidak menghentikan propagasi exception kecuali ada `return`/`throw` baru di dalamnya | Gunakan `finally` untuk cleanup (tutup resource, logging), bukan untuk mengubah alur normal program |
| `NullPointerException` padahal sudah pakai custom exception | Operator `!!` dipakai untuk memaksa unwrap nilai nullable, dan NPE ini tipenya beda dari exception kustom sehingga tidak tertangkap oleh `catch (e: InsufficientBalanceException)` | Hindari `!!`; gunakan `?:`, `require()`, atau `catch` terpisah untuk `NullPointerException` sesuai kebutuhan |

## Sumber Pustaka

- [Kotlin Exceptions](https://kotlinlang.org/docs/exceptions.html)
- [Kotlin Coding Conventions — Exceptions](https://kotlinlang.org/docs/coding-conventions.html#exceptions)
- Slide `Kotlin Dasar/P8 - Exceptions .pdf`
