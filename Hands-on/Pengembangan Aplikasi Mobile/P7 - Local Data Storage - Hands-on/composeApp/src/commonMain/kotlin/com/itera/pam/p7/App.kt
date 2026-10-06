package com.itera.pam.p7

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itera.pam.p7.db.AppDatabase
import com.itera.pam.p7.latihan.Handson1Screen
import com.itera.pam.p7.latihan.Handson2Screen
import com.itera.pam.p7.latihan.Handson3Screen
import com.itera.pam.p7.solusi.Handson1ScreenSolusi
import com.itera.pam.p7.solusi.Handson2ScreenSolusi
import com.itera.pam.p7.solusi.Handson3ScreenSolusi

// Menu sederhana berbasis state (BUKAN Navigation Component — itu materi
// Pertemuan 5) untuk berpindah antar layar latihan/solusi di hands-on ini.
private enum class Screen(val label: String) {
    Menu("Menu"),
    Latihan1("Latihan 1 - Preferensi Sederhana"), Solusi1("Solusi 1"),
    Latihan2("Latihan 2 - SQLDelight Repository"), Solusi2("Solusi 2"),
    Latihan3("Latihan 3 - Offline Notes"), Solusi3("Solusi 3"),
}

@Composable
fun App(database: AppDatabase) {
    MaterialTheme {
        var screen by remember { mutableStateOf(Screen.Menu) }

        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                if (screen != Screen.Menu) {
                    Button(onClick = { screen = Screen.Menu }) { Text("< Kembali ke Menu") }
                }
                when (screen) {
                    Screen.Menu -> {
                        Text("Hands-on Pertemuan 7")
                        Text("Local Data Persistence")
                        Screen.entries.filter { it != Screen.Menu }.forEach { s ->
                            Button(onClick = { screen = s }) { Text(s.label) }
                        }
                    }

                    Screen.Latihan1 -> Handson1Screen(database)
                    Screen.Solusi1 -> Handson1ScreenSolusi(database)
                    Screen.Latihan2 -> Handson2Screen(database)
                    Screen.Solusi2 -> Handson2ScreenSolusi(database)
                    Screen.Latihan3 -> Handson3Screen(database)
                    Screen.Solusi3 -> Handson3ScreenSolusi(database)
                }
            }
        }
    }
}
