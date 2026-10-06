package com.itera.pam.p6.latihan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Hands-on 3: Tampilkan Data di Compose dengan Loading/Error UI
// Tugas: pakai UserListStateHolder (dari Handson2Repository.kt) untuk
// menampilkan:
// - CircularProgressIndicator() selagi UiState.Loading
// - LazyColumn berisi nama & email user selagi UiState.Success
// - Pesan error + tombol "Coba Lagi" (yang memanggil ulang load()) selagi
//   UiState.Error
//
// CATATAN: fungsi ini sengaja belum menampilkan apa-apa selain placeholder —
// lengkapi semua TODO di bawah supaya UI-nya berfungsi.

@Composable
fun Handson3Screen() {
    // TODO 1: buat state holder: val holder = remember { UserListStateHolder() }
    // TODO 2: collect state-nya: val state by holder.state.collectAsState()
    // TODO 3: panggil holder.load() sekali saat pertama kali screen ini muncul,
    //         pakai: LaunchedEffect(Unit) { holder.load() }
    // TODO 4: buat scope coroutine untuk tombol retry:
    //         val scope = rememberCoroutineScope()
    // TODO 5: buat `when (state)` yang menangani 3 kasus:
    //         - UiState.Loading -> CircularProgressIndicator()
    //         - UiState.Success -> LazyColumn { items(state.users) { user -> ... } }
    //         - UiState.Error   -> Text(state.message) + Button("Coba Lagi") yang
    //                              memanggil scope.launch { holder.load() }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Belum diimplementasikan — lengkapi TODO 1-5 di atas")
    }
}
