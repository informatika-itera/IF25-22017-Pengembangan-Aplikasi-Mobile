package com.itera.pam.p6

actual fun getPlatformName(): String = "Desktop JVM ${System.getProperty("java.version")}"
