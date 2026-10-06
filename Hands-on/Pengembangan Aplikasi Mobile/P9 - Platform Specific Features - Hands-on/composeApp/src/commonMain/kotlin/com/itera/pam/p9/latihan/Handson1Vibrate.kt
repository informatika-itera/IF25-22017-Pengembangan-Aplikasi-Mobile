package com.itera.pam.p9.latihan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Hands-on 1: expect/actual Lanjutan — Getar Perangkat
// `vibrate()` sudah diimplementasikan lewat expect/actual (lihat Platform.kt
// dan actual-nya di androidMain/iosMain/desktopMain) — tugasmu di sini hanya
// memanggilnya dari tombol di bawah.
//
// TODO 1: import com.itera.pam.p9.vibrate
// TODO 2: Panggil vibrate() di dalam onClick tombol
// TODO 3: Tambahkan Text yang menjelaskan platform mana yang benar-benar
//         bergetar (Android & iOS bergetar sungguhan, Desktop hanya
//         mencetak log ke console)

@Composable
fun Handson1Screen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hands-on 1: Getar Perangkat (expect/actual)")
        Button(onClick = { /* TODO 2 */ }) {
            Text("Getar!")
        }
    }
}
