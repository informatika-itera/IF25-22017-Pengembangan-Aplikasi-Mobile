package com.itera.pam.p3

actual fun getPlatformName(): String = "Desktop JVM ${System.getProperty("java.version")}"
