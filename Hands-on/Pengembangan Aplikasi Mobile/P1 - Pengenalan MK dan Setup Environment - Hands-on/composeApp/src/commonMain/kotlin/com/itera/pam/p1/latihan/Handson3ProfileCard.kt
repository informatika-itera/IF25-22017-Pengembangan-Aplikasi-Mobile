package com.itera.pam.p1.latihan

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import com.itera.pam.p1.getPlatformNameimport androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Hands-on 3: Layout Dasar — Profile Card
// Tugas: Susun sebuah "kartu profil" sederhana berisi nama, NIM, dan platform
// yang sedang berjalan, menggunakan Card, Column, Row, dan Modifier.
//
// CATATAN: fungsi ini belum menampilkan apa-apa selain placeholder di bawah —
// lengkapi semua TODO supaya kartu profil muncul dengan benar.

/**
 * Tampilan kartu profil dasar yang berisi identitas dan nama platform saat ini.
 */
@Composable
fun Handson3Screen() {
    Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Nama: Fulan")
            Text("NIM: 123456")
            Row {
                Text("Platform: ")
                Text(getPlatformName())
            }
        }
    }
}
