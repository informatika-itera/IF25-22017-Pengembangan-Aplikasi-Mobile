package com.itera.pam.p1

actual fun getPlatformName(): String = "Desktop JVM ${System.getProperty("java.version")}"
