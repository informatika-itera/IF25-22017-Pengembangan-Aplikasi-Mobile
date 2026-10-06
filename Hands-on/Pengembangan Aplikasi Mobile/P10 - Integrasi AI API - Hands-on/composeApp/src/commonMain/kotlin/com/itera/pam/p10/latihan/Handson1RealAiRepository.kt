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
import com.itera.pam.p10.AiRepository
import com.itera.pam.p10.GEMINI_API_KEY
import com.itera.pam.p10.GEMINI_BASE_URL
import com.itera.pam.p10.GEMINI_MODEL
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

// Hands-on 1: Panggil AI API Dasar (Gemini)
// Tugas: lengkapi RealAiRepository.ask() supaya benar-benar memanggil
// Gemini API lewat Ktor, lalu parsing responsnya menjadi teks jawaban.
//
// Bentuk request Gemini (POST, JSON):
//   { "contents": [ { "parts": [ { "text": "<prompt>" } ] } ] }
// Bentuk response (disederhanakan):
//   { "candidates": [ { "content": { "parts": [ { "text": "<jawaban>" } ] } } ] }

@Serializable
data class GeminiPart(val text: String)

@Serializable
data class GeminiContent(val parts: List<GeminiPart>)

@Serializable
data class GeminiRequest(val contents: List<GeminiContent>)

@Serializable
data class GeminiCandidate(val content: GeminiContent? = null)

@Serializable
data class GeminiResponse(val candidates: List<GeminiCandidate>? = null)

class RealAiRepository(
    private val client: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
) : AiRepository {

    override suspend fun ask(prompt: String): Result<String> {
        // TODO 1: Buat request body:
        //   val requestBody = GeminiRequest(contents = listOf(GeminiContent(listOf(GeminiPart(prompt)))))
        // TODO 2: Kirim POST ke "$GEMINI_BASE_URL/$GEMINI_MODEL:generateContent?key=$GEMINI_API_KEY"
        //   val response = client.post(url) {
        //       contentType(ContentType.Application.Json)
        //       setBody(requestBody)
        //   }
        // TODO 3: Ambil body sebagai GeminiResponse:
        //   val geminiResponse = response.body<GeminiResponse>()
        // TODO 4: Ambil teks jawabannya:
        //   val text = geminiResponse.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text
        //   Jika `text` null (mis. jawaban diblokir safety filter Gemini),
        //   kembalikan Result.failure(Exception("Tidak ada jawaban dari Gemini (mungkin kena safety filter)"))
        // TODO 5: Bungkus semuanya dalam try/catch, kembalikan Result.failure(e)
        //   kalau terjadi exception (mis. HTTP error, network error)

        return Result.failure(NotImplementedError("Lengkapi TODO 1-5 di RealAiRepository.ask()"))
    }
}

@Composable
fun Handson1Screen() {
    var input by remember { mutableStateOf("Apa itu Kotlin Multiplatform? Jawab singkat.") }
    var result by remember { mutableStateOf("(belum ada jawaban)") }
    val scope = rememberCoroutineScope()
    val repository = remember { RealAiRepository() }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hands-on 1: Panggil Gemini API")
        Text("Butuh GEMINI_API_KEY asli di ApiConfig.kt — sebelum itu diisi, tombol ini akan gagal (itu wajar, lihat README bagian Troubleshooting).")
        OutlinedTextField(value = input, onValueChange = { input = it }, label = { Text("Pertanyaan") })
        Button(onClick = {
            scope.launch {
                result = repository.ask(input).fold(
                    onSuccess = { it },
                    onFailure = { "Error: ${it.message}" }
                )
            }
        }) {
            Text("Tanya AI (Real)")
        }
        Text(result)
    }
}
