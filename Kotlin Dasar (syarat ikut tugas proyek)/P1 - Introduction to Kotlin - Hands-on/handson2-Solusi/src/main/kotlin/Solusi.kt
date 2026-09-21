// Hands-on 2: Control Flow — when sebagai Expression
//solusi : when digunakan untuk memntukan grade berdasarkan nilai dan in digunakan
// untuk cek nilai dalam rentang

// menggunakan when sebagai expresion untuk evaluasi nilai
fun gradeOf(nilai: Int): String =
    when (nilai) {
        // cek rentang 90 -100 dan seterusnya untuk mendapatkan nilai
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        //fallback jika nilai diluar rentang di atas
        else -> "E"

fun main() {
    val nilaiMahasiswa = listOf(95, 82, 71, 60, 45)
    for (nilai in nilaiMahasiswa) {
        println("Nilai $nilai -> Grade ${gradeOf(nilai)}")
    }
}
