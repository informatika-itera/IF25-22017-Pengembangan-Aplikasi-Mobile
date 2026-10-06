// Hands-on 2: Lambda vs Function Reference
// Tugas: Punya list nama mahasiswa. Buat pipeline yang menyaring nama
// dengan panjang genap, lalu ubah semua jadi UPPERCASE — sekali menggunakan
// lambda, sekali lagi menggunakan function reference (::namaFungsi).
// Hasil kedua pipeline harus SAMA.

/**
 * Mengecek apakah jumlah huruf di dalam teks itu genap.
 */
fun isEvenLength(s: String): Boolean = s.length % 2 == 0

/**
 * Mengubah teks menjadi huruf besar semua.
 */
fun toUpper(s: String): String = s.uppercase()

fun main() {
    val mahasiswa = listOf("Andi", "Budi", "Citra", "Dewi", "Eka", "Fajar")

    val hasilLambda: List<String> = mahasiswa.filter { it.length % 2 == 0 }.map { it.uppercase() }

    val hasilReference: List<String> = mahasiswa.filter(::isEvenLength).map(::toUpper)

    println("Lambda   : $hasilLambda")
    println("Reference: $hasilReference")
    println("Sama? ${hasilLambda == hasilReference}")
}
