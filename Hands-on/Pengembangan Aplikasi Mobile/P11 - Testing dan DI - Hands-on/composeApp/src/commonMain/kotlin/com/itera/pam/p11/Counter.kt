package com.itera.pam.p11

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Kelas produksi kecil yang dipakai di ketiga latihan pertemuan ini sebagai
// "unit" yang diuji.
class Counter {
    private val _value = MutableStateFlow(0)
    val value: StateFlow<Int> = _value.asStateFlow()

    fun increment() {
        _value.value += 1
    }

    fun decrement() {
        if (_value.value > 0) _value.value -= 1
    }

    fun reset() {
        _value.value = 0
    }
}
