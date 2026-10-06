package com.itera.pam.p1

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Hands-on Pertemuan 1 — Introduction to KMP") {
        App()
    }
}
