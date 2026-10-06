package com.itera.pam.p11

import kotlin.time.Duration
import kotlin.time.TimeMark

// Mencatat berapa lama satu "sesi" berlangsung, menggunakan ClockProvider
// yang di-inject (bukan memanggil TimeSource.Monotonic langsung) supaya
// class ini gampang diuji dengan waktu palsu yang terkontrol.
class SessionLogger(private val clock: ClockProvider) {
    private var startMark: TimeMark? = null

    fun startSession() {
        startMark = clock.markNow()
    }

    fun endSession(): Duration {
        val start = startMark ?: error("Sesi belum dimulai — panggil startSession() dulu")
        return start.elapsedNow()
    }
}
