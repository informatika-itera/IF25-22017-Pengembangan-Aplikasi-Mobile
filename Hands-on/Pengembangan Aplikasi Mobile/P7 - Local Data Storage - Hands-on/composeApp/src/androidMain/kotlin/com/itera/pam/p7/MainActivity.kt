package com.itera.pam.p7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.itera.pam.p7.db.AppDatabase
import com.itera.pam.p7.db.DatabaseDriverFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = AppDatabase(DatabaseDriverFactory(applicationContext).createDriver())
        setContent {
            App(database)
        }
    }
}
