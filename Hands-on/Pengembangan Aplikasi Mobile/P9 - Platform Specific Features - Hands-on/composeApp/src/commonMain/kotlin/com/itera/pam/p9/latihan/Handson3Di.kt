package com.itera.pam.p9.latihan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Hands-on 3: Dependency Injection dengan Koin
// Modul Koin (`appModule`) dan `initKoin()` sudah disiapkan di
// com.itera.pam.p9.di.AppModule, dan sudah dipanggil dari MainActivity /
// MainViewController / main.kt sebelum UI dijalankan.
//
// TODO 1: import org.koin.compose.koinInject
// TODO 2: import com.itera.pam.p9.di.GreetingRepository
// TODO 3: Ambil instance GreetingRepository dengan koinInject<GreetingRepository>()
// TODO 4: Tampilkan hasil repository.greeting() di dalam Text()

@Composable
fun Handson3Screen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hands-on 3: Dependency Injection dengan Koin")
        Text("TODO: tampilkan pesan dari GreetingRepository di sini")
    }
}
