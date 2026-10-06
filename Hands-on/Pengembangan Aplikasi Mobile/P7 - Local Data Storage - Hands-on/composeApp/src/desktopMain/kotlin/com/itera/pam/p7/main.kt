package com.itera.pam.p7

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.itera.pam.p7.db.AppDatabase
import com.itera.pam.p7.db.DatabaseDriverFactory

fun main() = application {
    val database = AppDatabase(DatabaseDriverFactory().createDriver())
    Window(onCloseRequest = ::exitApplication, title = "Hands-on Pertemuan 7 — Local Data Persistence") {
        App(database)
    }
}
