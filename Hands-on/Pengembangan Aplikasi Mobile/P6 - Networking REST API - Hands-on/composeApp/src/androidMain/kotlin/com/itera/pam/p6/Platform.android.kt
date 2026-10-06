package com.itera.pam.p6

import android.os.Build

actual fun getPlatformName(): String = "Android ${Build.VERSION.SDK_INT}"
