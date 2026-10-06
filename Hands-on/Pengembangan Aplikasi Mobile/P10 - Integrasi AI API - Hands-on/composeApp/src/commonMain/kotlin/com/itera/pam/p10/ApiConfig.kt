package com.itera.pam.p10

// GANTI nilai di bawah dengan API key Gemini kamu sendiri untuk mencoba
// RealAiRepository dengan jawaban AI sungguhan.
//
// Cara mendapatkan API key GRATIS:
// 1. Buka https://aistudio.google.com/apikey
// 2. Login dengan akun Google, klik "Create API key"
// 3. Salin key-nya, tempel menggantikan "YOUR_API_KEY_HERE" di bawah
//
// PENTING — di aplikasi sungguhan JANGAN PERNAH commit API key ke repo
// publik! Cara yang benar: simpan di local.properties (sudah ada di
// .gitignore), lalu suntikkan ke BuildConfig lewat Gradle, atau lebih aman
// lagi ambil dari server backend milikmu sendiri saat runtime. Di hands-on
// ini kita pakai const val demi kesederhanaan, supaya fokus ke konsep
// integrasi AI API-nya, bukan ke konfigurasi build.
const val GEMINI_API_KEY = "YOUR_API_KEY_HERE"

const val GEMINI_MODEL = "gemini-1.5-flash"
const val GEMINI_BASE_URL = "https://generativelanguage.googleapis.com/v1beta/models"
