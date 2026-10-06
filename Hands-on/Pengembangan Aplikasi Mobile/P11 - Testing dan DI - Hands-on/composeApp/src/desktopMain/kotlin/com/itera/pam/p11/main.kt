package com.itera.pam.p11

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Hands-on Pertemuan 11 — Testing dan Dependency Injection") {
        App()
    }
}
