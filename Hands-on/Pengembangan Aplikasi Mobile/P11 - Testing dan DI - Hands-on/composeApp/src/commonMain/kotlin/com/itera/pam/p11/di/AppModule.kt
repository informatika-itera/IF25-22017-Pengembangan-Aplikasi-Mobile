package com.itera.pam.p11.di

import com.itera.pam.p11.ClockProvider
import com.itera.pam.p11.Counter
import com.itera.pam.p11.RealClockProvider
import com.itera.pam.p11.SessionLogger
import org.koin.dsl.module

// Modul Koin yang menyusun DI graph aplikasi ini. Lihat Hands-on 3
// (KoinModuleTest) yang memverifikasi modul ini benar-benar bisa di-resolve.
val appModule = module {
    single { Counter() }
    single<ClockProvider> { RealClockProvider() }
    single { SessionLogger(get()) }
}
