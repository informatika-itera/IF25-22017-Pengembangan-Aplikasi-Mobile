package com.itera.pam.p9

import platform.UIKit.UIDevice
import platform.UIKit.UIImpactFeedbackGenerator
import platform.UIKit.UIImpactFeedbackStyle

actual fun getPlatformName(): String {
    val device = UIDevice.currentDevice
    return "${device.systemName} ${device.systemVersion}"
}

// Catatan: API haptics UIKit ini belum diverifikasi lewat kompilasi Xcode asli
// (tidak ada toolchain iOS yang bisa dipakai untuk cek di lingkungan pembuatan
// hands-on ini) — kalau signature-nya berbeda di versi Kotlin/Native yang kamu
// pakai, cek dokumentasi UIImpactFeedbackGenerator terbaru.
actual fun vibrate() {
    val generator = UIImpactFeedbackGenerator(style = UIImpactFeedbackStyle.UIImpactFeedbackStyleMedium)
    generator.prepare()
    generator.impactOccurred()
}

actual fun hasCameraPermission(): Boolean = true // stub: model permission iOS di luar cakupan hands-on ini
