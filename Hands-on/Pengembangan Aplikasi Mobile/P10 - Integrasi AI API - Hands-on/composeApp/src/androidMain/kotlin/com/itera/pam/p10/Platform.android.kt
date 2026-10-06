package com.itera.pam.p10

import android.os.Build

actual fun getPlatformName(): String = "Android ${Build.VERSION.SDK_INT}"
