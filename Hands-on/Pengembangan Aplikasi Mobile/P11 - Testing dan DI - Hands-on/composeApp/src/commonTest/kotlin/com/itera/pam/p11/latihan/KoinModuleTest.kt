package com.itera.pam.p11.latihan

import com.itera.pam.p11.Counter
import com.itera.pam.p11.SessionLogger
import com.itera.pam.p11.di.appModule
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

// Hands-on 3: Koin DI Module
// Tugas: pastikan `appModule` (package `di`) benar-benar bisa di-resolve oleh
// Koin container, dan setiap dependency ter-hubung dengan benar.
class KoinModuleTest : KoinTest {

    // TODO 1: deklarasikan 2 property berikut:
    // private val counter: Counter by inject()
    // private val sessionLogger: SessionLogger by inject()

    @BeforeTest
    fun setup() {
        // TODO 2: startKoin { modules(appModule) }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun semuaDependencyDiAppModuleBerhasilDiResolve() {
        // TODO 3: assertNotNull(counter) dan assertNotNull(sessionLogger)
        TODO("Lengkapi test resolusi Koin module")
    }
}
