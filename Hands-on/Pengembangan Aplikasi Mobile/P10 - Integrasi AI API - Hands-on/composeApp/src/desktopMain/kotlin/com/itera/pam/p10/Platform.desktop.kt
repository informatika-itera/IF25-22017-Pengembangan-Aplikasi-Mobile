package com.itera.pam.p10

actual fun getPlatformName(): String = "Desktop JVM ${System.getProperty("java.version")}"
