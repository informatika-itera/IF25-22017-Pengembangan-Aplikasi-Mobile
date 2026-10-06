# Hands-on Pertemuan 4 (Kotlin Dasar) — Collections and Co.

Proyek Kotlin/JVM untuk 3 latihan praktikum Pertemuan 4 Kotlin Dasar (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA). Materi ini adalah bagian dari track suplemen **Kotlin Dasar** (di luar jadwal pertemuan utama P1-P4), berdasarkan slide `Kotlin Dasar/P4 - Collections and co..pdf`.

## Capaian Pembelajaran

- Memahami taksonomi collection di Kotlin: `Collection` vs `MutableCollection`, `List`, `Set`, `Map`
- Menggunakan operator fungsional dasar (`filter`, `map`, `sortedBy`) untuk mentransformasi collection
- Mengelompokkan dan mengagregasi data dengan `groupBy`, `sumOf`, dan `associateBy`
- Membedakan evaluasi *eager* (List) dan *lazy* (`Sequence`) serta tahu kapan masing-masing lebih tepat digunakan

## Cara Menjalankan

1. Buka folder **"P4 - Collections and co. - Hands-on"** ini di Android Studio (`File > Open`) sebagai proyek Gradle terpisah.
2. Tunggu proses Gradle sync selesai.
3. Buka file `Latihan.kt` pada modul yang ingin dikerjakan, lengkapi bagian `TODO`.
4. Klik ikon ▶️ di sebelah `fun main()` untuk menjalankan.
5. Jika stuck, bandingkan dengan `Solusi.kt` pada modul `-solusi` yang berpasangan.

Setiap latihan adalah modul Gradle terpisah, jadi latihan yang belum selesai (belum bisa di-compile) **tidak akan mengganggu** latihan atau solusi lain.

## Daftar Latihan

### 1. `handson1-latihan` / `handson1-solusi` — Transformasi Collection
Dari daftar `Product` (nama, harga, stok), hasilkan daftar **nama** produk yang harganya di atas threshold tertentu, terurut dari yang termurah.

- **Konsep:** `filter`, `sortedBy`, `map`.

### 2. `handson2-latihan` / `handson2-solusi` — Grouping & Aggregation
Dari daftar `Transaksi` (id, kategori, nominal), hitung total nominal per kategori, dan buat index pencarian transaksi berdasarkan ID.

- **Konsep:** `groupBy`, `mapValues`, `sumOf`, `associateBy`.

### 3. `handson3-latihan` / `handson3-solusi` — Sequence vs List (Lazy Evaluation)
Bandingkan performa pipeline `filter -> map -> take(5)` pada 1 juta angka menggunakan `List` biasa (eager) vs `Sequence` (lazy).

- **Catatan:** file `Latihan.kt` di modul ini **sengaja tidak bisa di-compile** sebelum kamu melengkapi TODO (menggunakan `TODO()`) — itu bagian dari latihan.
- **Konsep:** `asSequence()`, evaluasi lazy vs eager, terminal operation (`toList()`).

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| `ConcurrentModificationException` | Menambah/menghapus elemen `MutableList` saat sedang di-*iterate* dengan `for` biasa | Gunakan `MutableIterator.remove()`, atau buat salinan collection dulu sebelum diubah |
| `NoSuchElementException` pada `first()` / `single()` | Memanggil `first()`/`single()` pada collection kosong, atau `single()` pada collection dengan >1 elemen | Gunakan `firstOrNull()` / `singleOrNull()` dan tangani hasil `null`-nya |
| Hasil `Sequence` tidak muncul / mencetak `kotlin.sequences.TakeSequence@...` | Lupa memanggil operasi terminal (`toList()`, `count()`, `forEach()`, dll) — Sequence bersifat lazy dan baru dievaluasi saat operasi terminal dipanggil | Tambahkan operasi terminal di akhir chain, misalnya `.toList()` |

## Sumber Pustaka

- [Kotlin Collections Overview](https://kotlinlang.org/docs/collections-overview.html)
- [Sequences](https://kotlinlang.org/docs/sequences.html)
- [Collection Grouping](https://kotlinlang.org/docs/grouping.html)
