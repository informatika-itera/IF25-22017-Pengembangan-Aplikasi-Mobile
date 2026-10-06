# Hands-on Pertemuan 2 (Kotlin Dasar) — Object-Oriented Programming

Proyek Kotlin/JVM untuk 3 latihan praktikum materi **Kotlin Dasar — Object-Oriented Programming** (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA). Ini adalah bagian dari track suplemen **"Kotlin Dasar"** (dasar-dasar bahasa Kotlin di luar Compose/KMP) dan **berbeda** dari folder `P2 - Advanced Kotlin Coroutines Flow - Hands-on` di root repo, yang merupakan hands-on untuk Pertemuan 2 mata kuliah utama (Advanced Kotlin, Coroutines, Flow).

## Capaian Pembelajaran

- Memahami konsep class, object, constructor (primary/secondary), dan `init` block
- Menerapkan inheritance dengan `open class` dan `override`
- Membedakan penggunaan `interface` (abstraksi tanpa state) dan `data class` (pembawa data)
- Menggunakan `sealed class` untuk memodelkan state yang terbatas dan `when` yang exhaustive

## Cara Menjalankan

1. Buka folder **"P2 - Object-Oriented Programming - Hands-on"** ini (di dalam `Kotlin Dasar/`) di Android Studio (`File > Open`) sebagai proyek Gradle terpisah.
2. Tunggu proses Gradle sync selesai.
3. Buka file `Latihan.kt` pada modul yang ingin dikerjakan, lengkapi bagian `TODO`.
4. Klik ikon ▶️ di sebelah `fun main()` untuk menjalankan.
5. Jika stuck, bandingkan dengan `Solusi.kt` pada modul `-solusi` yang berpasangan.

Setiap latihan adalah modul Gradle terpisah, jadi latihan yang belum selesai (belum bisa di-compile) **tidak akan mengganggu** latihan atau solusi lain.

## Daftar Latihan

### 1. `handson1-latihan` / `handson1-solusi` — Class & Inheritance
Buat hierarki class `Vehicle` (open class) dengan turunan `Car` dan `Motorcycle` yang meng-override `describe()` untuk menambahkan info spesifik masing-masing kendaraan.

- **Konsep:** `open class`, `override`, primary constructor, `super`, polymorphism lewat `List<Vehicle>`.

### 2. `handson2-latihan` / `handson2-solusi` — Interface & Data Class
Buat interface `Payable` dengan `calculateSalary()`, implementasikan lewat `data class Employee`. Manfaatkan `copy()` untuk membuat variasi objek dan `equals()` bawaan untuk membandingkan berdasarkan isi (bukan referensi).

- **Konsep:** `interface`, `data class`, `copy()`, `equals()`/`toString()` otomatis.

### 3. `handson3-latihan` / `handson3-solusi` — Sealed Class untuk State
Modelkan hasil pemanggilan network sebagai `sealed class NetworkResult` dengan 3 state: `Loading` (object), `Success` (data class), dan `Error` (data class), lalu tangani semuanya dengan `when` yang exhaustive.

- **Catatan:** file `Latihan.kt` di modul ini **sengaja tidak bisa di-compile** sebelum kamu melengkapi TODO — itu bagian dari latihan.
- **Konsep:** `sealed class`, `object` sebagai singleton, `when` exhaustive tanpa `else`.

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| `This type is final, so it cannot be inherited from` | Class induk belum ditandai `open` | Tambahkan keyword `open` di depan `class` dan fungsi yang ingin di-override |
| `'describe' overrides nothing` | Fungsi induk belum ditandai `open`, atau nama/signature tidak cocok | Pastikan fungsi induk `open fun ...` dan signature (nama + parameter) identik |
| `'when' expression must be exhaustive` | Ada subclass `sealed class` yang belum ditangani di `when` | Tambahkan cabang `is NamaSubclass -> ...` untuk semua subclass, atau gunakan `else` sebagai fallback |

## Sumber Pustaka

- [Classes and Objects](https://kotlinlang.org/docs/classes.html)
- [Inheritance](https://kotlinlang.org/docs/inheritance.html)
- [Data Classes](https://kotlinlang.org/docs/data-classes.html)
- [Sealed Classes and Interfaces](https://kotlinlang.org/docs/sealed-classes.html)
