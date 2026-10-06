package com.itera.pam.p5

// expect/actual pattern: deklarasi di sini (commonMain), implementasi berbeda
// di androidMain (Platform.android.kt), iosMain (Platform.ios.kt), dan
// desktopMain (Platform.desktop.kt).
expect fun getPlatformName(): String
