package com.itera.pam.p6

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Hands-on Pertemuan 6 — Networking (Ktor Client & JSON)") {
        App()
    }
}
