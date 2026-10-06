package com.itera.pam.p11.latihan

import com.itera.pam.p11.ClockProvider
import com.itera.pam.p11.SessionLogger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.seconds
import kotlin.time.TestTimeSource
import kotlin.time.TimeMark
import kotlin.time.TimeSource

// Hands-on 2: Test Double — Fake ClockProvider
// Masalah: jika SessionLogger diuji dengan waktu ASLI (TimeSource.Monotonic
// sungguhan), hasil elapsed time-nya tidak bisa diprediksi persis -> test
// jadi flaky (kadang lolos, kadang gagal, tergantung kecepatan mesin).
// Solusi: gunakan TestTimeSource dari kotlin.time — "jam palsu" yang hanya
// maju kalau kita suruh maju secara manual, sehingga hasilnya deterministik.

// TODO 1: lengkapi class ini agar mendelegasikan seluruh kontrak TimeSource
//         ke `source` — ganti header class menjadi:
//         `class FakeClockProvider(...) : ClockProvider, TimeSource by source`
//         lalu HAPUS override markNow() di bawah ini (sudah tidak perlu lagi
//         begitu delegasinya ada).
class FakeClockProvider(val source: TestTimeSource = TestTimeSource()) : ClockProvider {
    // Placeholder SEMENTARA supaya file ini tetap bisa di-compile sebelum
    // TODO 1 dikerjakan (menghindari implementasi ClockProvider sendiri tanpa
    // delegasi TimeSource) — begitu delegasi `TimeSource by source` sudah
    // ditambahkan di header class, baris override ini harus dihapus.
    override fun markNow(): TimeMark = TODO("Kerjakan TODO 1 (delegasi ke `source`) dulu")
}

class SessionLoggerTest {

    @Test
    fun endSessionMengembalikanDurasiYangDimajukanPadaFakeClock() {
        // TODO 2: buat instance FakeClockProvider()
        // TODO 3: buat SessionLogger(fakeClock), lalu panggil startSession()
        // TODO 4: majukan waktu palsu 5 detik: fakeClock.source += 5.seconds
        // TODO 5: assertEquals(5.seconds, logger.endSession())
        TODO("Lengkapi test dengan FakeClockProvider")
    }
}
