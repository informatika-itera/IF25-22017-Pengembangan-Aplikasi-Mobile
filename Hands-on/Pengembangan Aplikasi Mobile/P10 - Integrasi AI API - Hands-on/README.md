# Hands-on Pertemuan 10 — Integrasi Sistem Cerdas (AI API)

Proyek Kotlin Multiplatform (KMP) + Compose Multiplatform untuk 3 latihan praktikum Pertemuan 10 (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA), dengan struktur proyek sungguhan (commonMain/androidMain/iosMain/desktopMain) yang sama seperti `P1 - Pengenalan MK dan Setup Environment - Hands-on/`.

**Catatan:** belum ada slide PDF untuk pertemuan ini — hands-on ini dirancang langsung dari RPS (Minggu 10, CPMK0503: "Mahasiswa mengintegrasikan AI API ke aplikasi", Bahan Kajian: OpenAI/Gemini API, Prompt Engineering, AI-powered Features).

## Capaian Pembelajaran

- Memanggil AI API (Google Gemini) dari aplikasi KMP menggunakan Ktor Client
- Menerapkan prompt engineering dasar (system instruction) untuk mengontrol gaya jawaban AI
- Membangun UI chat sederhana yang terhubung ke sebuah `AiRepository`
- Memahami Repository Pattern untuk memisahkan data asli (API) dari data simulasi (mock)

## Cara Menjalankan

1. Buka folder **"P10 - Integrasi AI API - Hands-on"** ini di Android Studio (`File > Open`), tunggu Gradle sync selesai.
2. Jalankan seperti biasa:
   - **Android** — configuration `composeApp`, pilih emulator/device, klik ▶️.
   - **Desktop** — `./gradlew :composeApp:run` (paling cepat untuk coba-coba).
   - **iOS** *(Mac + Xcode)* — folder `iosApp/` tidak disertakan; buat proyek baru via [kmp.jetbrains.com](https://kmp.jetbrains.com) lalu salin isi `composeApp/src/` dari sini.
3. Semua latihan **berjalan tanpa API key** karena secara default memakai `MockAiRepository` (jawaban simulasi setelah delay 1 detik) — cocok untuk dicoba langsung di kelas.
4. Untuk mencoba jawaban AI **sungguhan** (khususnya Latihan 1):
   - Buka https://aistudio.google.com/apikey, login dengan akun Google, klik "Create API key" (gratis).
   - Buka `composeApp/src/commonMain/kotlin/com/itera/pam/p10/ApiConfig.kt`, ganti `"YOUR_API_KEY_HERE"` dengan key tsb.
   - **Jangan commit key asli ke Git** — folder ini memang tidak dirancang untuk produksi; lihat komentar di `ApiConfig.kt` untuk cara yang benar di aplikasi sungguhan.
5. Menu di `App.kt` menggunakan state sederhana (bukan Navigation Component) untuk berpindah antar Latihan 1-3 dan Solusi 1-3.

## Daftar Latihan

### 1. `Handson1RealAiRepository.kt` — Panggil AI API Dasar
Lengkapi `RealAiRepository.ask()`: bangun request body Gemini (`@Serializable` data classes), kirim `POST` lewat Ktor, parsing response, ambil teks jawabannya, bungkus jadi `Result.success`/`Result.failure`.

- **Konsep:** Ktor `HttpClient`, `ContentNegotiation` + `kotlinx.serialization`, `Result<T>` untuk error handling tanpa exception mentah.

### 2. `Handson2PromptEngineering.kt` — Prompt Engineering
Lengkapi `buildPrompt()` agar menambahkan instruksi sistem (system instruction) di depan pertanyaan pengguna sebelum dikirim ke AI, supaya gaya jawabannya konsisten.

- **Konsep:** prompt engineering dasar, function composition sederhana.

### 3. `Handson3ChatScreen.kt` — AI-Powered Chat UI
Bangun UI chat: input teks, tombol kirim, daftar bubble pesan (`isUser`/`text`) yang scrollable, indikator loading saat menunggu `AiRepository.ask()`.

- **Catatan:** layar ini sengaja hanya menampilkan placeholder sebelum semua TODO dilengkapi.
- **Konsep:** `LazyColumn`, state list immutable, `rememberCoroutineScope()` untuk memanggil suspend function dari callback `onClick`.

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| Jawaban selalu "Error: ..." di Latihan 1/Solusi 1 | `GEMINI_API_KEY` masih `"YOUR_API_KEY_HERE"` (placeholder) | Isi API key asli dari https://aistudio.google.com/apikey di `ApiConfig.kt` |
| HTTP 400 Bad Request | Request body tidak sesuai format Gemini (mis. salah struktur JSON) | Cocokkan struktur `GeminiRequest`/`GeminiContent`/`GeminiPart` dengan dokumentasi Gemini API |
| HTTP 403 / API key invalid | Key salah ketik, sudah dihapus, atau kena rate limit | Generate key baru di aistudio.google.com, cek kuota gratis harian |
| `candidates` kosong / jawaban null | Prompt terkena safety filter Gemini, atau ada di region yang dibatasi | Ini situasi valid, bukan bug — pastikan `ask()` mengembalikan `Result.failure` dengan pesan yang jelas, bukan crash |
| App crash saat panggil API di Android | Lupa `<uses-permission android:name="android.permission.INTERNET" />` | Sudah ditambahkan di `AndroidManifest.xml` proyek ini — cek lagi jika kamu menyalin kode ke proyek lain |

## Sumber Pustaka

- [Gemini API Documentation](https://ai.google.dev/gemini-api/docs)
- [Ktor Client Documentation](https://ktor.io/docs/client-create-new-application.html)
- [Kotlinx Serialization Guide](https://kotlinlang.org/docs/serialization.html)
