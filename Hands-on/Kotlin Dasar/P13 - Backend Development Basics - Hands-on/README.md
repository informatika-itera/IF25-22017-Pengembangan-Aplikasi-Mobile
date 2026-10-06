# Hands-on Pertemuan 13 (Kotlin Dasar) — Backend Development Basics

Proyek Kotlin/JVM untuk 3 latihan praktikum Pertemuan 13 (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA), bagian dari materi tambahan **Kotlin Dasar**.

## Capaian Pembelajaran

- Memahami konsep dasar jaringan (IP, port, socket, TCP) dan model client-server
- Menjelaskan struktur HTTP request/response serta arti kode status (2xx, 3xx, 4xx, 5xx)
- Membuat HTTP server sederhana di Kotlin menggunakan `HttpServer` bawaan JDK
- Mengimplementasikan routing, response JSON, dan penanganan request/response secara manual

## Cara Menjalankan

1. Buka folder **"P13 - Backend Development Basics - Hands-on"** ini di Android Studio (`File > Open`) sebagai proyek Gradle terpisah.
2. Tunggu proses Gradle sync selesai.
3. Buka file `Latihan.kt` pada modul yang ingin dikerjakan, lengkapi bagian `TODO`.
4. Klik ikon ▶️ di sebelah `fun main()` untuk menjalankan. Server akan berjalan selama 10 detik lalu berhenti otomatis.
5. Saat server berjalan, buka terminal lain dan uji endpoint-nya dengan `curl` (contoh perintah ada di output program dan di bagian **Daftar Latihan** di bawah).
6. Jika stuck, bandingkan dengan `Solusi.kt` pada modul `-solusi` yang berpasangan.

Setiap latihan adalah modul Gradle terpisah, jadi latihan yang belum selesai (belum bisa di-compile) **tidak akan mengganggu** latihan atau solusi lain.

## Daftar Latihan

### 1. `handson1-latihan` / `handson1-solusi` — HTTP Server Sederhana
Buat `HttpServer` yang listen di port 8080 dan merespon `GET /hello` dengan teks statis `"Hello, Kotlin Backend!"`.

- **Uji dengan:** `curl http://localhost:8080/hello`
- **Konsep:** `HttpServer.create`, `createContext`, `sendResponseHeaders`, `responseBody`.

### 2. `handson2-latihan` / `handson2-solusi` — Routing & JSON Sederhana
Tambahkan route `GET /users` yang mengembalikan daftar user dalam format JSON (dibangun manual, tanpa library), lengkap dengan header `Content-Type: application/json`.

- **Uji dengan:** `curl http://localhost:8080/users`
- **Konsep:** routing berbasis path, serialisasi JSON manual, HTTP response header.

### 3. `handson3-latihan` / `handson3-solusi` — Request Handling & Status Code
Implementasikan `POST /echo` yang membaca body request lalu mengembalikannya apa adanya, ditambah handler default yang mengembalikan status `404 Not Found` untuk path yang tidak dikenal.

- **Uji dengan:** `curl -X POST -d 'halo dunia' http://localhost:8080/echo` dan `curl -i http://localhost:8080/tidak-ada`
- **Catatan:** file `Latihan.kt` di modul ini **sengaja tidak bisa di-compile** sebelum kamu melengkapi TODO — itu bagian dari latihan.
- **Konsep:** membaca request body, kode status HTTP (2xx/4xx/5xx), routing fallback.

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| `java.net.BindException: Address already in use` | Port 8080 sudah dipakai proses lain (mis. run sebelumnya belum benar-benar berhenti) | Tunggu beberapa detik sampai port terlepas, atau ganti port di `InetSocketAddress` |
| Program langsung berhenti tanpa merespon request | Lupa memanggil `server.start()` setelah `createContext` didaftarkan | Pastikan `server.start()` dipanggil sebelum `Thread.sleep` |
| `curl` menampilkan JSON sebagai teks polos / client gagal parse JSON | Lupa set header `Content-Type: application/json` sebelum `sendResponseHeaders` | Panggil `exchange.responseHeaders.set("Content-Type", "application/json")` **sebelum** `sendResponseHeaders` |

## Sumber Pustaka

- [`com.sun.net.httpserver.HttpServer` — JDK Javadoc](https://docs.oracle.com/en/java/javase/17/docs/api/jdk.httpserver/com/sun/net/httpserver/HttpServer.html)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Ktor — Framework Kotlin untuk Backend](https://ktor.io/) — setelah memahami dasar HTTP server di atas, gunakan Ktor untuk membangun backend Kotlin yang lebih serius (routing, content negotiation, authentication, testing bawaan).
