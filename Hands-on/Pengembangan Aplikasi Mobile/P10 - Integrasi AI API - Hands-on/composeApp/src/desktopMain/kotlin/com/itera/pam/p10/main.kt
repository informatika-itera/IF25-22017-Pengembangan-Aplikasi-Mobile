package com.itera.pam.p10

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Hands-on Pertemuan 10 — Integrasi Sistem Cerdas (AI API)") {
        App()
    }
}
