package com.itera.pam.p7

actual fun getPlatformName(): String = "Desktop JVM ${System.getProperty("java.version")}"
