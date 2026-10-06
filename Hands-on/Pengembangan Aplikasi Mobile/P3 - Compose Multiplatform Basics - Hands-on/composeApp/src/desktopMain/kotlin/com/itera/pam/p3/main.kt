package com.itera.pam.p3

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Hands-on Pertemuan 3 — Compose Multiplatform Basics") {
        App()
    }
}
