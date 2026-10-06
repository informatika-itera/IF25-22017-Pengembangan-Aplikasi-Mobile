package com.itera.pam.p5

actual fun getPlatformName(): String = "Desktop JVM ${System.getProperty("java.version")}"
