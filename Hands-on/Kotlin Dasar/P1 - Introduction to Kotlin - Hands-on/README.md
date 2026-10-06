# Hands-on Pertemuan 1 — Introduction to Kotlin

Proyek Kotlin/JVM untuk 3 latihan praktikum Pertemuan 1 — Kotlin Dasar (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA).

## Capaian Pembelajaran

- Memahami perbedaan `val` (immutable) dan `var` (mutable), serta `const val`
- Menulis fungsi Kotlin, termasuk single-expression function dan default parameter
- Menggunakan `if` dan `when` sebagai expression untuk mengontrol alur program
- Menggunakan loop (`for`, ranges, `step`) dan operasi dasar pada `List`
- Menerapkan null safety: safe call (`?.`), elvis operator (`?:`), dan `filterNotNull()`

## Cara Menjalankan

1. Buka folder **"P1 - Introduction to Kotlin - Hands-on"** ini di Android Studio (`File > Open`) sebagai proyek Gradle terpisah.
2. Tunggu proses Gradle sync selesai.
3. Buka file `Latihan.kt` pada modul yang ingin dikerjakan, lengkapi bagian `TODO`.
4. Klik ikon ▶️ di sebelah `fun main()` untuk menjalankan.
5. Jika stuck, bandingkan dengan `Solusi.kt` pada modul `-solusi` yang berpasangan.

Setiap latihan adalah modul Gradle terpisah, jadi latihan yang belum selesai (belum bisa di-compile) **tidak akan mengganggu** latihan atau solusi lain.

## Daftar Latihan

### 1. `handson1-latihan` / `handson1-solusi` — Variabel, Fungsi & String Template
Lengkapi `describeProfile()` yang mencetak deskripsi profil menggunakan string template, default parameter, dan penanganan nilai `Int?` yang mungkin null.

- **Konsep:** `val`/`var`, string template (`$var`, `${expr}`), default parameter, named argument, safe call (`?.`), elvis operator (`?:`).

### 2. `handson2-latihan` / `handson2-solusi` — Control Flow dengan `when` Expression
Lengkapi `gradeOf()` yang mengklasifikasikan nilai ujian (0-100) menjadi huruf mutu A-E menggunakan `when` sebagai **expression** dalam single-expression function.

- **Catatan:** sebelum dilengkapi, fungsi ini memanggil `TODO()` — kode tetap **bisa di-compile**, tapi akan melempar `NotImplementedError` saat dijalankan.
- **Konsep:** `when` sebagai expression, range (`in 90..100`), single-expression function (`fun ... = ...`).

### 3. `handson3-latihan` / `handson3-solusi` — Loops, Ranges & Null Safety
Lengkapi `ScoreBoard` agar bisa menyaring skor valid (membuang `null`) yang memenuhi batas kelulusan, lalu cetak bilangan ganjil menggunakan range ber-`step`.

- **Catatan:** file `Latihan.kt` di modul ini **sengaja tidak bisa di-compile** sebelum kamu melengkapi TODO — itu bagian dari latihan.
- **Konsep:** `filterNotNull()`, `filter`, `sortedDescending()`, range dengan `step`, class dengan constructor property.

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| `Val cannot be reassigned` | Mencoba mengubah nilai `val` setelah diinisialisasi | Gunakan `var` jika nilai memang perlu diubah, atau pastikan hanya `val` yang dibaca |
| `Unresolved reference: skorValid` (handson3) | Property `skorValid` belum dideklarasikan (masih berupa komentar TODO) | Tambahkan `val skorValid: List<Int> = skorMentah.filterNotNull()` di dalam class |
| `An operation is not implemented: ...` (`NotImplementedError`) | Fungsi masih memanggil `TODO()` dan belum diimplementasikan | Ganti pemanggilan `TODO()` dengan implementasi sesuai instruksi komentar |

## Sumber Pustaka

- [Kotlin Basic Syntax](https://kotlinlang.org/docs/basic-syntax.html)
- [Kotlin Null Safety](https://kotlinlang.org/docs/null-safety.html)
- [Kotlin Control Flow (if/when)](https://kotlinlang.org/docs/control-flow.html)
