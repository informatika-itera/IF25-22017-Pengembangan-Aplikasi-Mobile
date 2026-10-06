package com.itera.pam.p9

actual fun getPlatformName(): String = "Desktop JVM ${System.getProperty("java.version")}"

actual fun vibrate() {
    println("Desktop tidak mendukung getar (vibrate) — no-op.")
}

actual fun hasCameraPermission(): Boolean = true // stub: model permission Desktop di luar cakupan hands-on ini
