package com.itera.pam.p3.latihan

import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeightimport androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Hands-on 1: ProfileCard (lihat slide "P3 - Compose Multiplatform Basics.pdf" hal. 30)
// Tugas: Buat komponen ProfileCard dengan avatar, nama, dan bio.

/**
 * Komponen untuk menampilkan profil pengguna dalam bentuk kartu bergambar.
 */
@Composable
fun ProfileCard(name: String, bio: String) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(48.dp).background(Color.Gray, CircleShape),
                contentAlignment = Alignment.Center
            ) { Icon(Icons.Default.Person, contentDescription = null) }
            Column(modifier = Modifier.padding(start = 12.dp)) {
                Text(name, fontWeight = FontWeight.Bold)
                Text(bio, color = Color.Gray)
            }
        }
    }
}

@Composable
fun Handson1Screen() {
    ProfileCard(name = "John Doe", bio = "Mobile Developer")
}
