package com.itera.pam.p11

import kotlin.time.TimeSource

// ClockProvider adalah kontrak sumber waktu yang bisa ditukar: implementasi
// asli (RealClockProvider, berbasis TimeSource.Monotonic) untuk produksi, atau
// sebuah TestTimeSource (jam palsu bawaan kotlin.time) untuk pengujian —
// lihat Hands-on 2 di commonTest (FakeClockProvider).
interface ClockProvider : TimeSource

class RealClockProvider : ClockProvider, TimeSource by TimeSource.Monotonic
