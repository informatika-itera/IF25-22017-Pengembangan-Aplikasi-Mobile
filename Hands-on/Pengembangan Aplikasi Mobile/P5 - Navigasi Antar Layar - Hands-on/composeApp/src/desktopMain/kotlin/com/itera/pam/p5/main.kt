package com.itera.pam.p5

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Hands-on Pertemuan 5 — Navigasi Antar Layar") {
        App()
    }
}
