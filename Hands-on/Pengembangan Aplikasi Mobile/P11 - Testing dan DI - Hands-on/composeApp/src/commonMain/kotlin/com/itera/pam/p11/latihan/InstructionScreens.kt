package com.itera.pam.p11.latihan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Hands-on Pertemuan 11 berbeda dari pertemuan lain: latihan sungguhannya
// berupa FILE TEST di commonTest/ (topiknya adalah unit testing), bukan
// layar UI. Layar-layar di bawah ini murni instruksional — mengarahkan kamu
// ke file test yang harus dilengkapi.

@Composable
fun Handson1Screen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hands-on 1: Unit Test Dasar — Counter")
        Text("Buka: composeApp/src/commonTest/kotlin/.../p11/latihan/CounterTest.kt")
        Text("Lengkapi 3 TODO mengikuti pola Arrange-Act-Assert, lalu jalankan test-nya lewat IDE (klik ▶️ di sebelah class/fun test) atau `./gradlew :composeApp:desktopTest`.")
    }
}

@Composable
fun Handson2Screen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hands-on 2: Test Double — Fake ClockProvider")
        Text("Buka: composeApp/src/commonTest/kotlin/.../p11/latihan/SessionLoggerTest.kt")
        Text("Lengkapi class FakeClockProvider (delegasikan ke TestTimeSource) dan test-nya, lalu jalankan.")
    }
}

@Composable
fun Handson3Screen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hands-on 3: Koin DI Module")
        Text("Buka: composeApp/src/commonTest/kotlin/.../p11/latihan/KoinModuleTest.kt")
        Text("Lengkapi property `by inject<T>()` dan startKoin(...) di setup(), lalu jalankan.")
    }
}
