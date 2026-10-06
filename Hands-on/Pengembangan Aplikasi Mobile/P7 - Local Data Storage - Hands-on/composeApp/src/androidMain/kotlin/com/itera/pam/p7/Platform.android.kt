package com.itera.pam.p7

import android.os.Build

actual fun getPlatformName(): String = "Android ${Build.VERSION.SDK_INT}"
