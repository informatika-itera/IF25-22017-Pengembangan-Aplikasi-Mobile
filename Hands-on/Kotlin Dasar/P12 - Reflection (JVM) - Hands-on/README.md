# Hands-on Pertemuan 12 (Kotlin Dasar) — Reflection (JVM)

Proyek Kotlin/JVM untuk 3 latihan praktikum Pertemuan 12 seri **Kotlin Dasar** (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA). Materi ini adalah bagian dari track suplemen "Kotlin Dasar" yang melengkapi materi utama mata kuliah.

## Capaian Pembelajaran

- Menjelaskan konsep reflection dan `KClass<T>` sebagai entry point reflection di Kotlin
- Menggunakan `memberProperties` untuk memeriksa struktur kelas secara dinamis saat runtime
- Membaca nilai property sebuah objek secara generik tanpa hardcode nama field
- Membuat custom annotation dan memanfaatkannya bersama reflection untuk validasi data

## Cara Menjalankan

1. Buka folder **"P12 - Reflection (JVM) - Hands-on"** ini di Android Studio (`File > Open`) sebagai proyek Gradle terpisah.
2. Tunggu proses Gradle sync selesai.
3. Buka file `Latihan.kt` pada modul yang ingin dikerjakan, lengkapi bagian `TODO`.
4. Klik ikon ▶️ di sebelah `fun main()` untuk menjalankan.
5. Jika stuck, bandingkan dengan `Solusi.kt` pada modul `-solusi` yang berpasangan.

Setiap latihan adalah modul Gradle terpisah, jadi latihan yang belum selesai (belum bisa di-compile) **tidak akan mengganggu** latihan atau solusi lain.

## Daftar Latihan

### 1. `handson1-latihan` / `handson1-solusi` — Inspeksi Kelas dengan KClass
Gunakan `product::class` untuk mendapatkan `KClass<Product>`, lalu cetak nama kelas dan daftar nama seluruh property-nya lewat `memberProperties`.

- **Konsep:** `KClass`, `::class`, `memberProperties`.

### 2. `handson2-latihan` / `handson2-solusi` — Baca Nilai Property Dinamis
Buat fungsi generik `printFields(obj: Any)` yang mencetak semua nama dan nilai property objek apapun (mirip `toString()` otomatis) menggunakan `property.getter.call(obj)`, tanpa hardcode nama field.

- **Konsep:** `memberProperties`, `KProperty.getter`, generic reflection.

### 3. `handson3-latihan` / `handson3-solusi` — Custom Annotation + Reflection Validator
Buat `annotation class Required`, lalu `fun validate(obj: Any): List<String>` yang secara reflectively mengecek semua property beranotasi `@Required` tidak null/blank, dan mengembalikan daftar nama field yang gagal validasi.

- **Catatan:** file `Latihan.kt` di modul ini **sengaja tidak bisa di-compile** sebelum kamu melengkapi TODO (annotation class-nya masih di-comment) — itu bagian dari latihan.
- **Konsep:** custom `annotation class`, `@Target`, `@Retention(RUNTIME)`, `javaField`, validasi generik ala framework (Spring-style).

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| `Unresolved reference: memberProperties` | Lupa menambahkan dependency `kotlin-reflect` | Pastikan `build.gradle.kts` punya `implementation(kotlin("reflect"))` pada `subprojects`, lalu Gradle sync ulang |
| `getAnnotation(...)` selalu mengembalikan `null` padahal annotation sudah dipasang | Annotation tidak diberi `@Retention(AnnotationRetention.RUNTIME)` (default retention Kotlin sebenarnya RUNTIME, tapi mudah salah jika retention diubah manual) | Pastikan `annotation class` punya `@Retention(AnnotationRetention.RUNTIME)` agar tetap terbaca saat program berjalan |
| `IllegalCallableAccessException` / `IllegalAccessException` saat memanggil `property.getter.call(obj)` | Property atau kelasnya bersifat `private` sehingga tidak bisa diakses reflection dari luar | Set `property.isAccessible = true` sebelum memanggil `call()`, atau jadikan property/kelas `public` jika memungkinkan |

## Sumber Pustaka

- [Kotlin Reflection Documentation](https://kotlinlang.org/docs/reflection.html)
- [Annotations in Kotlin](https://kotlinlang.org/docs/annotations.html)
- [kotlin.reflect.full package (KDoc)](https://kotlinlang.org/api/core/kotlin-reflect/kotlin.reflect.full/)
