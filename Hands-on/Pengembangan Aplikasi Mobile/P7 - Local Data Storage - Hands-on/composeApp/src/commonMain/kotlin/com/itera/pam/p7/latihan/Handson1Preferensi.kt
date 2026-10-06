package com.itera.pam.p7.latihan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itera.pam.p7.db.AppDatabase

// Hands-on 1: "DataStore Preferences Sederhana"
//
// CATATAN PENTING: DataStore Preferences versi Multiplatform butuh setup
// tambahan (okio + path provider per-platform) yang cukup rumit untuk
// hands-on pengantar dan berisiko salah tanpa bisa di-compile-check.
// Sebagai gantinya, kita simulasikan KONSEP yang sama persis — menyimpan
// satu nilai key-value yang tetap ada lintas restart aplikasi — memakai
// tabel `Preferensi` pada database SQLDelight yang sama (lihat Preferensi.sq).
// Pola read-modify-write-nya identik dengan cara kerja DataStore.
//
// Tugas: simpan & tampilkan "jumlah aplikasi dibuka", yang bertambah 1
// setiap kali layar ini dibuka, dan nilainya PERSISTEN (coba tutup lalu
// buka lagi aplikasinya — nilainya harus lanjut, bukan reset ke 0/1).

private const val KEY_JUMLAH_DIBUKA = "jumlah_dibuka"

@Composable
fun Handson1Screen(database: AppDatabase) {
    var jumlah by remember { mutableStateOf(0L) }

    LaunchedEffect(Unit) {
        // TODO 1: baca nilai lama dengan
        //         database.preferensiQueries.selectByKey(KEY_JUMLAH_DIBUKA)
        //             .executeAsOneOrNull()?.prefValue?.toLongOrNull() ?: 0L
        // TODO 2: hitung nilai baru = nilai lama + 1
        // TODO 3: simpan nilai baru dengan
        //         database.preferensiQueries.upsert(KEY_JUMLAH_DIBUKA, nilaiBaru.toString())
        // TODO 4: update state `jumlah` dengan nilai baru tsb
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hands-on 1: Preferensi Sederhana")
        Text("Aplikasi ini sudah dibuka: $jumlah kali")
    }
}
