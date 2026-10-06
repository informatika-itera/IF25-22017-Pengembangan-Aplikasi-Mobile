package com.itera.pam.p6

import platform.UIKit.UIDevice

actual fun getPlatformName(): String {
    val device = UIDevice.currentDevice
    return "${device.systemName} ${device.systemVersion}"
}
