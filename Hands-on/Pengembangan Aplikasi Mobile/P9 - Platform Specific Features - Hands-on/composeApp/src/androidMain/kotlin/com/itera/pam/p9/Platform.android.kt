package com.itera.pam.p9

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.core.content.ContextCompat

// Simplifikasi untuk hands-on ini: object ini di-set sekali dari
// MainActivity.onCreate sebelum UI dijalankan, supaya fungsi `actual` di
// file ini bisa mengakses Context Android tanpa perlu expect class dengan
// constructor injection. Pada aplikasi produksi, pertimbangkan DI (mis.
// Koin androidContext()) atau expect class alih-alih object global ini.
object AndroidAppContext {
    var context: Context? = null
}

actual fun getPlatformName(): String = "Android ${Build.VERSION.SDK_INT}"

actual fun vibrate() {
    val ctx = AndroidAppContext.context ?: return
    val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val manager = ctx.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        manager.defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        ctx.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }
    vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
}

actual fun hasCameraPermission(): Boolean {
    val ctx = AndroidAppContext.context ?: return false
    return ContextCompat.checkSelfPermission(ctx, Manifest.permission.CAMERA) ==
        PackageManager.PERMISSION_GRANTED
}
