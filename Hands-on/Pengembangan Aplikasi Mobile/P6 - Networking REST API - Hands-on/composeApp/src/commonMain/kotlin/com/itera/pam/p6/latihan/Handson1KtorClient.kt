package com.itera.pam.p6.latihan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.call.body
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

// Hands-on 1: Ktor Client Dasar & GET Request
// Endpoint yang dipakai di seluruh hands-on Pertemuan 6:
// https://jsonplaceholder.typicode.com/users (fake REST API gratis untuk belajar,
// mengembalikan array JSON berisi data user).

@Serializable
data class RemoteUser(
    val id: Int,
    val name: String,
    val email: String
)

// TODO 1: Buat HttpClient dengan ContentNegotiation + json() supaya Ktor bisa
//         otomatis decode response JSON menjadi objek Kotlin.
//         val client = HttpClient {
//             install(ContentNegotiation) {
//                 json(Json { ignoreUnknownKeys = true })
//             }
//         }
val client: HttpClient = TODO("Buat HttpClient dengan plugin ContentNegotiation + json()")

// TODO 2: Lakukan GET request ke "https://jsonplaceholder.typicode.com/users"
//         dan decode response body-nya menjadi List<RemoteUser>.
suspend fun fetchUsers(): List<RemoteUser> {
    // Kode kamu di sini...
    // return client.get("https://jsonplaceholder.typicode.com/users").body()
    TODO("Panggil client.get(...) lalu .body<List<RemoteUser>>()")
}

@Composable
fun Handson1Screen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hands-on 1: Ktor Client Dasar & GET Request")
        Text("Lengkapi TODO di Handson1KtorClient.kt, lalu lihat Solusi 1 untuk contoh pemanggilan fetchUsers() dari Composable.")
    }
}
