# Hands-on Pertemuan 7 (Kotlin Dasar) — Asynchronous Programming in Kotlin

Proyek Kotlin/JVM untuk 3 latihan praktikum materi *Kotlin Dasar* Pertemuan 7 (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA). Materi ini adalah bagian dari track suplemen **Kotlin Dasar** yang membahas fondasi coroutine dari nol (suspend function, launch vs async, structured concurrency) — melengkapi (bukan menggantikan) hands-on **Advanced Kotlin Coroutines & Flow** pada pertemuan utama mata kuliah (`P2 - Advanced Kotlin Coroutines Flow - Hands-on`).

## Capaian Pembelajaran

- Menjelaskan mengapa pemrograman asynchronous dibutuhkan (keterbatasan thread & blocking call)
- Memahami konsep `suspend function` dan aturan pemanggilannya
- Membedakan penggunaan `launch` (fire-and-forget) dan `async`/`await` (butuh nilai balik)
- Menerapkan structured concurrency: parent `Job`, child coroutine, dan `cancel()`

## Cara Menjalankan

1. Buka folder **"P7 - Asynchronous Programming in Kotlin - Hands-on"** ini di Android Studio (`File > Open`) sebagai proyek Gradle terpisah.
2. Tunggu proses Gradle sync selesai.
3. Buka file `Latihan.kt` pada modul yang ingin dikerjakan, lengkapi bagian `TODO`.
4. Klik ikon ▶️ di sebelah `fun main()` untuk menjalankan.
5. Jika stuck, bandingkan dengan `Solusi.kt` pada modul `-solusi` yang berpasangan.

Setiap latihan adalah modul Gradle terpisah, jadi latihan yang belum selesai (belum bisa di-compile) **tidak akan mengganggu** latihan atau solusi lain.

## Daftar Latihan

### 1. `handson1-latihan` / `handson1-solusi` — Suspend Function Dasar
Buat `suspend fun checkOrderStatus()` yang mensimulasikan panggilan server (delay 2 detik), lalu panggil dari dalam `runBlocking` tanpa memblokir thread OS.

- **Konsep:** `suspend fun`, `delay`, "suspend function hanya bisa dipanggil dari coroutine atau suspend fun lain".

### 2. `handson2-latihan` / `handson2-solusi` — launch vs async
Ada 2 tugas simulasi (logging & menghitung total harga). Pilih coroutine builder yang tepat: `launch` untuk tugas tanpa nilai balik, `async`/`await` untuk tugas yang hasilnya dibutuhkan.

- **Konsep:** `launch`, `Job`, `async`, `Deferred`, `await()`.

### 3. `handson3-latihan` / `handson3-solusi` — Structured Concurrency & Cancellation
Implementasikan `DownloadManager` yang menjalankan beberapa "download" sebagai child coroutine dari satu parent `Job`. Batalkan parent `Job` dan buktikan seluruh child yang belum selesai ikut berhenti.

- **Catatan:** file `Latihan.kt` di modul ini **sengaja tidak bisa di-compile** sebelum kamu melengkapi TODO — itu bagian dari latihan.
- **Konsep:** `Job()`, `CoroutineScope`, parent-child job hierarchy, `cancel()`.

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| `Suspend function 'xxx' should be called only from a coroutine or another suspend function` | Memanggil suspend fun langsung dari `fun main()` biasa (tanpa `runBlocking`) | Bungkus pemanggilan dalam coroutine builder (`runBlocking`, `launch`, `async`) |
| Program selesai lebih cepat dari yang diharapkan, sebagian `println` di dalam `launch` tidak sempat tercetak | `runBlocking` selesai sebelum child coroutine yang dijalankan lewat `launch` sempat menyelesaikan `delay` | Tunggu job-nya (`job.join()`) atau tambahkan `delay` di akhir `main` sebelum program berakhir |
| `JobCancellationException` muncul padahal tidak diharapkan | Parent `Job`/scope dibatalkan sebelum child coroutine selesai | Ini perilaku normal dari structured concurrency — pastikan `cancel()` hanya dipanggil saat memang ingin menghentikan semua child |

## Sumber Pustaka

- [Coroutines basics](https://kotlinlang.org/docs/coroutines-basics.html)
- [Cancellation and timeouts](https://kotlinlang.org/docs/cancellation-and-timeouts.html)
- [Coroutine context and dispatchers](https://kotlinlang.org/docs/coroutine-context-and-dispatchers.html)
