package com.itera.pam.p7.latihan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itera.pam.p7.db.AppDatabase
import com.itera.pam.p7.db.Catatan
import kotlinx.coroutines.flow.Flow

// Hands-on 2: SQLDelight — Insert & Query
// Lengkapi CatatanRepository di bawah agar bisa membaca semua catatan
// sebagai Flow (otomatis emit ulang saat data berubah) dan menambah/
// menghapus catatan. Kamu akan memakai repository ini di Latihan 3.

class CatatanRepository(private val database: AppDatabase) {

    fun getAll(): Flow<List<Catatan>> {
        // TODO 1: import app.cash.sqldelight.coroutines.asFlow dan
        //         app.cash.sqldelight.coroutines.mapToList, lalu:
        //         return database.catatanQueries.selectAll()
        //             .asFlow()
        //             .mapToList(kotlinx.coroutines.Dispatchers.Default)
        TODO("Lengkapi getAll()")
    }

    fun tambah(judul: String, isi: String) {
        // TODO 2: database.catatanQueries.insertCatatan(judul, isi)
    }

    fun hapus(id: Long) {
        // TODO 3: database.catatanQueries.deleteById(id)
    }
}

@Composable
fun Handson2Screen(database: AppDatabase) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hands-on 2: SQLDelight Repository")
        Text("Lengkapi CatatanRepository di file ini (Handson2Repository.kt), lalu buka Latihan 3 untuk mencobanya langsung di UI.")
    }
}
