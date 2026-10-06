import kotlin.reflect.full.memberProperties

// Hands-on 1: Inspeksi Kelas dengan KClass
// Tugas: Gunakan Kotlin Reflection API (KClass) untuk mencetak nama kelas
// dan daftar nama seluruh property milik kelas Product, TANPA menyebut
// nama property-nya secara hardcode (harus lewat reflection).

data class Product(val nama: String, val harga: Int)

fun main() {
    val product = Product("Kopi Susu", 18000)

    // TODO 1: Ambil KClass dari objek product, misal dengan `product::class`
    // TODO 2: Cetak nama kelasnya dengan `.simpleName`
    // TODO 3: Iterasi `memberProperties` dari KClass tersebut, cetak `.name`
    //         setiap property (gunakan import kotlin.reflect.full.memberProperties di atas)

    // Kode kamu di sini...

    // Output yang diharapkan:
    // Kelas: Product
    // Properties:
    // - nama
    // - harga
}
