package com.itera.pam.p1.latihan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itera.pam.p1.getPlatformName

// Hands-on 1: Expect/Actual — Info Platform
// getPlatformName() sudah didefinisikan lewat expect/actual (lihat Platform.kt
// dan Platform.android.kt / Platform.ios.kt / Platform.desktop.kt).
//
// TODO 1: Panggil getPlatformName() untuk mendapatkan nama platform saat ini
// TODO 2: Kembalikan pesan sapaan yang menyebutkan nama platform tsb,
//         contoh: "Halo dari Android 34!" / "Halo dari Desktop JVM 21!"

/**
 * Mengambil informasi platform yang sedang berjalan (seperti Android atau Desktop),
 * lalu membuat pesan sapaan.
 */
fun getGreetingMessage(): String {
    return "Halo dari ${getPlatformName()}!"
}

@Composable
fun Handson1Screen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hands-on 1: Expect/Actual")
        Text(getGreetingMessage())
    }
}
