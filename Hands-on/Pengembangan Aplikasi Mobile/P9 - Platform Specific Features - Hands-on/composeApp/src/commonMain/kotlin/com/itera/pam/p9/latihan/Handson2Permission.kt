package com.itera.pam.p9.latihan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Hands-on 2: Permission Check (Platform-Aware)
// `hasCameraPermission()` sudah diimplementasikan lewat expect/actual: cek
// ASLI di Android (ContextCompat.checkSelfPermission), stub `true` di
// iOS/Desktop karena model permission-nya berbeda dan di luar cakupan
// hands-on ini.
//
// TODO 1: import com.itera.pam.p9.hasCameraPermission
// TODO 2: Tampilkan status izin kamera memakai hasCameraPermission()
// TODO 3: Tampilkan pesan berbeda tergantung true/false-nya

@Composable
fun Handson2Screen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hands-on 2: Permission Check")
        Text("Status izin kamera: ???") // TODO 2 & 3
        Button(onClick = { /* simulasi tombol minta izin, di luar cakupan hands-on ini */ }) {
            Text("Simulasikan Minta Izin")
        }
    }
}
