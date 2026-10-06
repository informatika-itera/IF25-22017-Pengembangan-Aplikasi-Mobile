package com.itera.pam.p10

import kotlinx.coroutines.delay

// Dipakai sebagai default di semua latihan supaya bisa dicoba di kelas
// TANPA perlu API key Gemini asli dulu. Setelah ApiConfig.GEMINI_API_KEY
// diisi dengan key sungguhan, ganti MockAiRepository() dengan
// RealAiRepository() (lihat handson1) di layar mana pun yang ingin diuji
// dengan jawaban AI sungguhan.
class MockAiRepository : AiRepository {
    override suspend fun ask(prompt: String): Result<String> {
        delay(1000) // simulasi latensi jaringan
        return Result.success(
            "Ini jawaban simulasi (mock) untuk prompt:\n\"$prompt\"\n\n" +
                "Ganti MockAiRepository() dengan RealAiRepository() setelah " +
                "GEMINI_API_KEY di ApiConfig.kt diisi dengan key asli."
        )
    }
}
