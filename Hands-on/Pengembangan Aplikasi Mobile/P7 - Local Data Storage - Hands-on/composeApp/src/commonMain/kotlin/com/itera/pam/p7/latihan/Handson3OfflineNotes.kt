package com.itera.pam.p7.latihan

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itera.pam.p7.db.AppDatabase

// Hands-on 3: Offline-First — Tampilkan & Hapus Catatan
// Gunakan CatatanRepository dari Handson2Repository.kt (yang sudah kamu
// lengkapi) untuk menampilkan daftar catatan dalam LazyColumn, form untuk
// menambah catatan baru, dan tombol hapus per item.
//
// CATATAN: layar ini SENGAJA belum menampilkan apa pun (hanya placeholder
// di bawah) sampai semua TODO dilengkapi.

@Composable
fun Handson3Screen(database: AppDatabase) {
    // TODO 1: buat val repository = remember { CatatanRepository(database) }
    // TODO 2: collect repository.getAll() sebagai Compose state, misalnya:
    //         val catatanList by repository.getAll().collectAsState(initial = emptyList())
    // TODO 3: tampilkan `catatanList` dengan LazyColumn { items(catatanList) { catatan -> ... } }
    //         setiap item: Text(catatan.judul), Text(catatan.isi),
    //         Button("Hapus") { repository.hapus(catatan.id) }
    // TODO 4: tambahkan 2 OutlinedTextField (judul, isi) + Button("Tambah")
    //         yang memanggil repository.tambah(judul, isi) lalu mengosongkan field
    // TODO 5: build & jalankan, tutup aplikasi, lalu buka lagi — catatan
    //         yang kamu tambahkan harus tetap ada (itulah "offline-first")

    Text(
        "Belum diimplementasikan — lengkapi TODO 1-5 di atas",
        modifier = Modifier.padding(16.dp)
    )
}
