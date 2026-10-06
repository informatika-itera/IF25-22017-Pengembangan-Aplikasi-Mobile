package com.itera.pam.p9

// expect/actual: deklarasi di commonMain, implementasi berbeda di
// androidMain (Platform.android.kt), iosMain (Platform.ios.kt), dan
// desktopMain (Platform.desktop.kt).
expect fun getPlatformName(): String

// Getar perangkat — hanya benar-benar bergetar di Android & iOS,
// no-op (hanya log) di Desktop.
expect fun vibrate()

// Cek izin kamera — implementasi ASLI di Android via ContextCompat,
// stub `true` di iOS/Desktop karena model permission-nya berbeda dan
// di luar cakupan hands-on ini.
expect fun hasCameraPermission(): Boolean
