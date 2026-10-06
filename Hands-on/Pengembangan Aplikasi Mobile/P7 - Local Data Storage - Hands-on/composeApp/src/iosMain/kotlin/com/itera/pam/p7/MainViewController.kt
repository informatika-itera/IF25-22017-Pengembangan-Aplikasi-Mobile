package com.itera.pam.p7

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.itera.pam.p7.db.AppDatabase
import com.itera.pam.p7.db.DatabaseDriverFactory

fun MainViewController() = ComposeUIViewController {
    val database = remember { AppDatabase(DatabaseDriverFactory().createDriver()) }
    App(database)
}
