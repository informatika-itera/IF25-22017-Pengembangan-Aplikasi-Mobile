package com.itera.pam.p1

import platform.UIKit.UIDevice

actual fun getPlatformName(): String {
    val device = UIDevice.currentDevice
    return "${device.systemName} ${device.systemVersion}"
}
