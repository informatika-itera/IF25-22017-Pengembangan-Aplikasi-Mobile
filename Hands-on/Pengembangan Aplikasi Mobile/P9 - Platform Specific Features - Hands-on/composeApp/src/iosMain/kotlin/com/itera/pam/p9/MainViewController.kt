package com.itera.pam.p9

import androidx.compose.ui.window.ComposeUIViewController
import com.itera.pam.p9.di.initKoin
import org.koin.core.context.GlobalContext
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    if (GlobalContext.getOrNull() == null) {
        initKoin()
    }
    return ComposeUIViewController { App() }
}
