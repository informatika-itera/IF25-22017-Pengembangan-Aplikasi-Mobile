package com.itera.pam.p10.latihan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itera.pam.p10.MockAiRepository
import kotlinx.coroutines.launch

// Hands-on 2: Prompt Engineering — System Instruction
// Tugas: lengkapi buildPrompt() agar menambahkan instruksi "system" di depan
// pertanyaan pengguna, supaya gaya jawaban AI konsisten.

fun buildPrompt(userInput: String): String {
    // TODO 1: Buat systemInstruction, misalnya:
    //   "Kamu adalah asisten yang menjawab singkat, maksimal 2 kalimat, dalam Bahasa Indonesia."
    // TODO 2: Gabungkan systemInstruction + userInput jadi satu prompt lengkap
    //         (mis. dipisah baris kosong), lalu return hasilnya.

    return userInput // TODO: masih mengembalikan input mentah, belum ada instruksi sistem
}

private val mockRepository = MockAiRepository()

@Composable
fun Handson2Screen() {
    var input by remember { mutableStateOf("Apa itu Kotlin Multiplatform?") }
    var promptPreview by remember { mutableStateOf("") }
    var answer by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hands-on 2: Prompt Engineering")
        OutlinedTextField(value = input, onValueChange = { input = it }, label = { Text("Pertanyaan") })
        Button(onClick = {
            promptPreview = buildPrompt(input)
            scope.launch {
                answer = mockRepository.ask(promptPreview).getOrElse { "Error: ${it.message}" }
            }
        }) {
            Text("Kirim (dengan System Instruction)")
        }

        Text("Prompt yang dikirim ke AI:")
        Text(promptPreview.ifBlank { "(belum dikirim)" })
        Text("Jawaban AI (mock):")
        Text(answer.ifBlank { "(belum ada jawaban)" })
    }
}
