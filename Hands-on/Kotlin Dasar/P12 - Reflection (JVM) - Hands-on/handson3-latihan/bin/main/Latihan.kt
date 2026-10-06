import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.findAnnotation

// Hands-on 3: Custom Annotation + Reflection Validator
// Tugas: Buat annotation class @Required, lalu fungsi validate(obj) yang
// mengecek semua property beranotasi @Required tidak boleh null atau
// String kosong/blank. Kembalikan daftar NAMA FIELD yang gagal validasi.
//
// CATATAN: File ini SENGAJA belum bisa di-compile sampai kamu melengkapi
// semua TODO di bawah — itu normal untuk latihan ini!

// TODO 1: Buat annotation class bernama Required.
//         Jangan lupa @Target(AnnotationTarget.FIELD) dan
//         @Retention(AnnotationRetention.RUNTIME) — tanpa RUNTIME,
//         annotation tidak akan terbaca saat reflection!
// annotation class Required

data class RegistrasiForm(
    @Required val nama: String,
    @Required val email: String,
    val alamat: String? // opsional, tidak wajib diisi
)

fun validate(obj: Any): List<String> {
    val gagal = mutableListOf<String>()

    // TODO 2: Iterasi memberProperties dari obj::class
    // TODO 3: Untuk tiap property, cek apakah punya annotation @Required
    //         dengan property.javaField?.getAnnotation(Required::class.java) != null
    //         (atau bila menganotasi property Kotlin: findAnnotation<Required>())
    // TODO 4: Jika beranotasi @Required, ambil nilainya dengan property.getter.call(obj)
    // TODO 5: Jika nilai null ATAU (String dan blank), tambahkan property.name ke `gagal`

    // Kode kamu di sini...

    return gagal
}

fun main() {
    val formValid = RegistrasiForm("Siti", "siti@mail.com", null)
    println("Form valid -> gagal: ${validate(formValid)}") // gagal: []

    val formInvalid = RegistrasiForm("", "budi@mail.com", "Jl. Merdeka")
    println("Form invalid -> gagal: ${validate(formInvalid)}") // gagal: [nama]
}
