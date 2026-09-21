// Hands-on 2: Lambda vs Function Reference

// Solusi: Menggunakan filter dan map, pertama dengan lambda lalu dengan
// function reference agar kedua hasil pipeline tetap sama.
fun isEvenLength(s: String): Boolean = s.length % 2 == 0

fun toUpper(s: String): String = s.uppercase()

fun main() {
    val mahasiswa = listOf("Andi", "Budi", "Citra", "Dewi", "Eka", "Fajar")

    // Memfilter nama yang memiliki jumlah karakter genap,
    // lalu mengubah nama yang lolos menjadi huruf kapital menggunakan lambda.
    val hasilLambda: List<String> = mahasiswa
        .filter { it.length % 2 == 0 }
        .map { it.uppercase() }

    // Memfilter nama dengan function reference isEvenLength,
    // lalu mengubahnya menjadi huruf kapital dengan function reference toUpper.
    val hasilReference: List<String> = mahasiswa
        .filter(::isEvenLength)
        .map(::toUpper)

    println("Lambda   : $hasilLambda")
    println("Reference: $hasilReference")
    println("Sama? ${hasilLambda == hasilReference}")
}
