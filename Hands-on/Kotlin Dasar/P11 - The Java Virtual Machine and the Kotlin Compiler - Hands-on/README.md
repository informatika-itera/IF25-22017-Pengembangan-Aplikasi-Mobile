# Hands-on Pertemuan 11 (Kotlin Dasar) — The Java Virtual Machine and the Kotlin Compiler

Proyek Kotlin/JVM untuk 3 latihan praktikum Pertemuan 11 pada seri suplemen **Kotlin Dasar** (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA).

## Capaian Pembelajaran

- Menjelaskan konsep type erasure pada JVM dan bagaimana `inline` + `reified` mengatasinya
- Memahami stack frame JVM dan bagaimana `tailrec` mengoptimasi rekursi menjadi loop
- Menjelaskan perbedaan bytecode yang dihasilkan `companion object` biasa vs dengan `@JvmStatic`
- Menggunakan `java.lang.Class` reflection untuk membuktikan struktur method hasil kompilasi Kotlin

## Cara Menjalankan

1. Buka folder **"P11 - The Java Virtual Machine and the Kotlin Compiler - Hands-on"** ini di Android Studio / IntelliJ (`File > Open`) sebagai proyek Gradle terpisah.
2. Tunggu proses Gradle sync selesai.
3. Buka file `Latihan.kt` pada modul yang ingin dikerjakan, lengkapi bagian `TODO`.
4. Klik ikon ▶️ di sebelah `fun main()` untuk menjalankan.
5. Jika stuck, bandingkan dengan `Solusi.kt` pada modul `-solusi` yang berpasangan.

Setiap latihan adalah modul Gradle terpisah, jadi latihan yang belum selesai (belum bisa di-compile) **tidak akan mengganggu** latihan atau solusi lain.

## Daftar Latihan

### 1. `handson1-latihan` / `handson1-solusi` — Inline Function & Reified Generics
Lengkapi `isType()` agar bisa memeriksa tipe generik pada runtime menggunakan `value is T`, sesuatu yang mustahil dilakukan pada generic function biasa karena type erasure di JVM.

- **Konsep:** type erasure, `inline`, `reified`.

### 2. `handson2-latihan` / `handson2-solusi` — Tailrec Optimization
Ubah fungsi factorial rekursif biasa (yang StackOverflowError untuk n besar) menjadi versi `tailrec` yang dioptimasi compiler menjadi loop, sehingga aman untuk n = 100.000.

- **Konsep:** stack frame JVM, tail call, `tailrec`.

### 3. `handson3-latihan` / `handson3-solusi` — companion object & @JvmStatic
Tambahkan `@JvmStatic` pada fungsi di `companion object` agar benar-benar menjadi static method di level bytecode JVM, lalu buktikan lewat `Greeter::class.java.methods` (reflection Java biasa, bukan kotlin-reflect).

- **Catatan:** file `Latihan.kt` di modul ini **sengaja tidak lolos assertion (`check`)** sebelum kamu melengkapi TODO — itu bagian dari latihan.
- **Konsep:** `companion object`, `@JvmStatic`, interop Java, `java.lang.Class` reflection.

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| `StackOverflowError` saat memanggil factorial dengan n besar | Rekursi biasa menumpuk stack frame di memori stack JVM yang kecil (~1024 KB) | Gunakan `tailrec` jika pemanggilan rekursif berada di posisi terakhir (tail call) |
| `This declaration needs opt-in / Cannot use 'T' as reified type parameter` | Memakai `is T` pada fungsi generik tanpa `reified`, atau memakai `reified` tanpa `inline` | Tambahkan `inline` pada fungsi DAN `reified` pada parameter tipenya |
| `greet` tidak muncul di `Greeter::class.java.methods` | Fungsi di companion object belum diberi `@JvmStatic`, jadi hanya jadi instance method di kelas `Companion` | Tambahkan `@JvmStatic` di atas fungsi dalam companion object |

## Sumber Pustaka

- [Inline Functions — Kotlin Docs](https://kotlinlang.org/docs/inline-functions.html)
- [Calling Kotlin from Java (JvmStatic)](https://kotlinlang.org/docs/java-to-kotlin-interop.html)
- Slide `Kotlin Dasar/P11 - The Java Virtual Machine and the Kotlin Compiler.pdf` — materi JVM bytecode, garbage collection, JIT compilation, dan pipeline Kotlin compiler (Parser → Frontend → Backend/IR).
