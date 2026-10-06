package com.itera.pam.p10.latihan

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Hands-on 3: AI-Powered Chat UI
// Tugas: buat UI chat sederhana: TextField input, tombol "Kirim", daftar
// bubble pesan (isUser: Boolean, text: String) yang bisa di-scroll, dan
// indikator loading saat menunggu jawaban dari AiRepository.ask()
// (pakai MockAiRepository() secara default).
//
// CATATAN: layar ini sengaja hanya menampilkan placeholder di bawah sampai
// semua TODO dilengkapi — itu bagian dari latihan.

data class ChatMessage(val isUser: Boolean, val text: String)

@Composable
fun Handson3Screen() {
    // TODO 1: Buat state `messages`: remember { mutableStateOf(listOf<ChatMessage>()) }
    // TODO 2: Buat state `input` (String, awalnya "") dan `isLoading` (Boolean, awalnya false)
    // TODO 3: Buat Column berisi:
    //   - LazyColumn yang menampilkan semua `messages` (beda alignment untuk isUser=true/false)
    //   - CircularProgressIndicator jika isLoading == true
    //   - Row berisi OutlinedTextField(input) + Button("Kirim")
    // TODO 4: Saat "Kirim" diklik:
    //   - tambahkan ChatMessage(isUser = true, text = input) ke `messages`
    //   - kosongkan `input`, set isLoading = true
    //   - di dalam rememberCoroutineScope().launch { ... }, panggil
    //     MockAiRepository().ask(pertanyaan), lalu tambahkan hasilnya sebagai
    //     ChatMessage(isUser = false, text = hasil) ke `messages`
    //   - set isLoading = false setelah selesai

    Text(
        "Belum diimplementasikan — lengkapi TODO 1-4 di atas",
        modifier = Modifier.padding(16.dp)
    )
}
