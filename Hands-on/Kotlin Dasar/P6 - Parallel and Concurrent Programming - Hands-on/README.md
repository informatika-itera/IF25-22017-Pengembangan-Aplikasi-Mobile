# Hands-on Pertemuan 6 (Kotlin Dasar) — Parallel and Concurrent Programming

Proyek Kotlin/JVM untuk 3 latihan praktikum Pertemuan 6 track **Kotlin Dasar**
(IF25-22017 — Pengembangan Aplikasi Mobile, ITERA). Materi ini fokus pada
`Thread` mentah dan `java.util.concurrent` di JVM (bukan Kotlin Coroutines —
itu dibahas di Pertemuan 7, Asynchronous Programming in Kotlin), sebagai
fondasi untuk memahami *mengapa* coroutines dibutuhkan.

## Capaian Pembelajaran

- Membedakan konsep parallel vs concurrent programming
- Membuat dan menjalankan thread di Kotlin/JVM (`Thread`, `Runnable`, `kotlin.concurrent.thread`)
- Menjelaskan penyebab race condition pada shared mutable state
- Menerapkan mekanisme sinkronisasi (`synchronized`, lock) untuk mengamankan shared state
- Menggunakan `ExecutorService`/`Future` dan `BlockingQueue` dari `java.util.concurrent`

## Cara Menjalankan

1. Buka folder **"P6 - Parallel and Concurrent Programming - Hands-on"** ini di Android Studio (`File > Open`) sebagai proyek Gradle terpisah.
2. Tunggu proses Gradle sync selesai.
3. Buka file `Latihan.kt` pada modul yang ingin dikerjakan, lengkapi bagian `TODO`.
4. Klik ikon ▶️ di sebelah `fun main()` untuk menjalankan.
5. Jika stuck, bandingkan dengan `Solusi.kt` pada modul `-solusi` yang berpasangan.

Setiap latihan adalah modul Gradle terpisah, jadi latihan yang belum selesai (belum bisa di-compile) **tidak akan mengganggu** latihan atau solusi lain.

## Daftar Latihan

### 1. `handson1-latihan` / `handson1-solusi` — Race Condition
Dua thread meng-increment shared `Counter` sebanyak 100.000x masing-masing secara bersamaan tanpa sinkronisasi. Buktikan hasil akhirnya sering **salah** (bukan 200.000), lalu perbaiki dengan `synchronized`.

- **Target:** hasil akhir SELALU tepat 200.000, walau dijalankan berkali-kali.
- **Konsep:** race condition, shared mutable state, `synchronized`, intrinsic lock (monitor).

### 2. `handson2-latihan` / `handson2-solusi` — ExecutorService & Future
Jalankan 4 perhitungan "berat" (disimulasikan dengan `Thread.sleep`) secara paralel menggunakan thread pool, kumpulkan hasilnya dengan `Future.get()`.

- **Target:** total waktu eksekusi ~1000ms (bukan ~4000ms jika sequential).
- **Konsep:** `Executors.newFixedThreadPool`, `Callable`, `Future`, `shutdown()`.

### 3. `handson3-latihan` / `handson3-solusi` — Producer-Consumer dengan BlockingQueue
Implementasikan pola producer-consumer: satu thread menaruh pesan ke `LinkedBlockingQueue`, satu thread lain mengambil dan mencetaknya, berhenti saat menerima sentinel value.

- **Catatan:** file `Latihan.kt` di modul ini **sengaja tidak bisa di-compile** sebelum kamu melengkapi TODO — itu bagian dari latihan.
- **Konsep:** `LinkedBlockingQueue`, `put()`/`take()` (blocking), sentinel value.

## Troubleshooting

| Error / Gejala | Penyebab | Solusi |
|---|---|---|
| Hasil akhir counter tidak konsisten (kadang 200000, kadang kurang) | Dua thread membaca-ubah-tulis `var c` secara bersamaan tanpa sinkronisasi (race condition) | Bungkus operasi baca-ubah-tulis dengan `synchronized(this) { }` atau pakai `AtomicInteger` |
| Program tidak pernah berhenti (hang) setelah `future.get()` selesai | Lupa memanggil `executor.shutdown()` — thread pool bukan daemon thread | Selalu panggil `executor.shutdown()` setelah selesai memakai `ExecutorService` |
| `IllegalMonitorStateException` | Memanggil `wait()`/`notify()` di luar blok `synchronized` pada objek yang sama | Pastikan `wait()`/`notify()` dipanggil di dalam `synchronized(objek)` pada `objek` yang sama |
| Consumer hang menunggu selamanya di `queue.take()` | Producer tidak pernah mengirim sentinel/tanda selesai ke queue | Pastikan producer selalu `queue.put(PESAN_SELESAI)` di akhir, walau lewat jalur exception |

## Sumber Pustaka

- [Kotlin: Shared mutable state and concurrency](https://kotlinlang.org/docs/shared-mutable-state-and-concurrency.html)
- [Java `java.util.concurrent` package docs](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/package-summary.html)
- [Baeldung — Guide to the Java ExecutorService](https://www.baeldung.com/java-executor-service-tutorial)
