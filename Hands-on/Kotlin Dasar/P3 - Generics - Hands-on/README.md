# Hands-on Pertemuan 3 (Kotlin Dasar) — Generics

Proyek Kotlin/JVM untuk 3 latihan praktikum Pertemuan 3 track **Kotlin Dasar** (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA). Track ini adalah materi pendukung/dasar Kotlin, terpisah dari jadwal pertemuan utama mata kuliah.

## Capaian Pembelajaran

- Membuat dan menggunakan generic class dengan type parameter
- Menerapkan bounded type parameter (upper bound) untuk membatasi tipe generik
- Memahami konsep variance (`out`/`in`) dan star-projection pada generics Kotlin
- Menjelaskan mengapa generic Kotlin bersifat invariant secara default

## Cara Menjalankan

1. Buka folder **"P3 - Generics - Hands-on"** ini di Android Studio (`File > Open`) sebagai proyek Gradle terpisah.
2. Tunggu proses Gradle sync selesai.
3. Buka file `Latihan.kt` pada modul yang ingin dikerjakan, lengkapi bagian `TODO`.
4. Klik ikon ▶️ di sebelah `fun main()` untuk menjalankan.
5. Jika stuck, bandingkan dengan `Solusi.kt` pada modul `-solusi` yang berpasangan.

Setiap latihan adalah modul Gradle terpisah, jadi latihan yang belum selesai (belum bisa di-compile) **tidak akan mengganggu** latihan atau solusi lain.

## Daftar Latihan

### 1. `handson1-latihan` / `handson1-solusi` — Generic Class `Box<T>`
Lengkapi class generik `Box<T>` dengan fungsi `map<R>(transform: (T) -> R): Box<R>` yang mentransformasikan isi Box menjadi Box baru bertipe berbeda.

- **Konsep:** generic class, type parameter, type inference.

### 2. `handson2-latihan` / `handson2-solusi` — Bounded Type Parameter
Implementasikan `findMax` generik yang mencari nilai terbesar dari sebuah `List<T>`, dengan constraint `T : Comparable<T>` agar elemen bisa dibandingkan.

- **Konsep:** bounded type parameter (upper bound), `Comparable<T>`.

### 3. `handson3-latihan` / `handson3-solusi` — Variance (`out`)
Tandai `Container<T>` dengan modifier variance yang tepat agar `Container<Cat>` bisa dianggap sebagai `Container<Animal>`.

- **Catatan:** file `Latihan.kt` di modul ini **sengaja tidak bisa di-compile** sebelum kamu melengkapi TODO — itu bagian dari latihan.
- **Konsep:** declaration-site variance, covariance (`out`), subtyping generic.

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| `Type mismatch. Required: Container<Animal>. Found: Container<Cat>` | Generic Kotlin invariant secara default — `Container<Cat>` tidak otomatis jadi subtipe `Container<Animal>` | Tambahkan modifier `out` pada type parameter jika hanya diproduksi (`fun get(): T`), tidak pernah dikonsumsi |
| `[TYPE_VARIANCE_CONFLICT_ERROR] Type parameter T is declared as 'out' but occurs in 'in' position` | T ditandai `out` tapi masih dipakai sebagai parameter fungsi (posisi konsumsi) | Gunakan `in` jika T hanya dikonsumsi, atau biarkan invariant (tanpa modifier) jika T dikonsumsi & diproduksi |
| `Cannot use 'T' as reified type parameter` / unchecked cast warning saat memakai star-projection `<*>` | Star-projection (`Holder<*>`) tidak menyimpan informasi tipe konkret, sehingga tidak bisa memanggil fungsi yang butuh T spesifik sebagai parameter | Gunakan bounded type parameter atau generic function biasa jika tipe konkret dibutuhkan, star-projection hanya untuk kasus "tidak peduli tipe apa" |

## Sumber Pustaka

- [Kotlin Generics](https://kotlinlang.org/docs/generics.html)
- [Declaration-site variance](https://kotlinlang.org/docs/generics.html#declaration-site-variance)
- [Type projections (use-site variance)](https://kotlinlang.org/docs/generics.html#type-projections)
