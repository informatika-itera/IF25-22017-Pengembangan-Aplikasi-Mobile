package com.itera.pam.p3.latihan

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.background
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifierimport androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Hands-on 3: Product List (lihat slide "P3 - Compose Multiplatform Basics.pdf" hal. 32)
// Tugas: Tampilkan daftar produk (gambar, nama, harga) menggunakan Card + Row + Column.

data class Produk(val nama: String, val harga: String, val warna: Color)

val daftarProdukContoh = listOf(
    Produk("Produk 1", "Rp 100.000", Color(0xFF009688)),
    Produk("Produk 2", "Rp 250.000", Color(0xFF9C27B0)),
    Produk("Produk 3", "Rp 75.000", Color(0xFF4CAF50)),
)

/**
 * Tampilan satu buah produk dengan gambar warna, nama, dan harga.
 */
@Composable
fun ProdukItem(produk: Produk) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Row(modifier = Modifier.padding(8.dp)) {
            Box(modifier = Modifier.size(80.dp).background(produk.warna))
            Column(modifier = Modifier.padding(start = 12.dp)) {
                Text(produk.nama)
                Text(produk.harga, color = Color.Gray)
            }
        }
    }
}

@Composable
fun Handson3Screen() {
    Column {
        daftarProdukContoh.forEach { produk ->
            ProdukItem(produk)
        }
    }
}
