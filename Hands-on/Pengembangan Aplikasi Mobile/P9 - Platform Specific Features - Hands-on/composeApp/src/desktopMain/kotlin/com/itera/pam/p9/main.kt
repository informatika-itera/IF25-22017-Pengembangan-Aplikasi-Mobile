package com.itera.pam.p9

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.itera.pam.p9.di.initKoin
import org.koin.core.context.GlobalContext

fun main() {
    if (GlobalContext.getOrNull() == null) {
        initKoin()
    }
    application {
        Window(onCloseRequest = ::exitApplication, title = "Hands-on Pertemuan 9 — Platform Specific Code") {
            App()
        }
    }
}
