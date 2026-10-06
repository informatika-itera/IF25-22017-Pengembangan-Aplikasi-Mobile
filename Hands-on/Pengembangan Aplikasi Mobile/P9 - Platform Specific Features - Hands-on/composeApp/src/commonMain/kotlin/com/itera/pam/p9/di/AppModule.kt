package com.itera.pam.p9.di

import org.koin.core.context.startKoin
import org.koin.dsl.module

interface GreetingRepository {
    fun greeting(): String
}

class GreetingRepositoryImpl : GreetingRepository {
    override fun greeting(): String = "Halo dari GreetingRepository (disuntik oleh Koin)!"
}

val appModule = module {
    single<GreetingRepository> { GreetingRepositoryImpl() }
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}
