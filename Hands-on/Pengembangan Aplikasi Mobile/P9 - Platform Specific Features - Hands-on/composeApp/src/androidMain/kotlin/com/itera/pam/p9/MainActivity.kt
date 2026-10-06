package com.itera.pam.p9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.itera.pam.p9.di.initKoin
import org.koin.core.context.GlobalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidAppContext.context = applicationContext
        // Guard supaya Koin tidak di-start dua kali saat Activity di-recreate
        // (mis. saat rotasi layar) tanpa proses aplikasi benar-benar restart.
        if (GlobalContext.getOrNull() == null) {
            initKoin()
        }
        setContent {
            App()
        }
    }
}
