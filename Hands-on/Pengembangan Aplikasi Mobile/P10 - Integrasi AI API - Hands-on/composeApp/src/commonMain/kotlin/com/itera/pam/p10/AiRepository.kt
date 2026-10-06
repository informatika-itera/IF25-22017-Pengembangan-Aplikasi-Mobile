package com.itera.pam.p10

// Kontrak bersama supaya UI (Composable) tidak peduli apakah jawaban AI
// datang dari API sungguhan (RealAiRepository) atau data simulasi
// (MockAiRepository) — pola ini disebut Repository Pattern.
interface AiRepository {
    suspend fun ask(prompt: String): Result<String>
}
