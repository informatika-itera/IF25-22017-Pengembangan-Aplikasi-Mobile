// Hands-on 1: Variabel, Fungsi & String Template
//solusi :
// safe call (?.) digunakan untuk mengecek nilai umur,
// sedangkan elvis operator (?:) digunakan jika umur bernilai null.

fun describeProfile(nama: String, umur: Int?, kota: String = "Tidak diketahui"): String {
    //   Gunakan safe call (?.) dan elvis operator (?:)
    val umurText = umur?.let { "$it tahun" } ?: "umur tidak diketahui"

    // Mengembalikan teks profil menggunakan string template ($nama, $umurText, $kota)
    return "Nama: $nama, Umur: $umurText, Kota: $kota"
}

fun main() {
    println(describeProfile("Andi", 20, "Bandar Lampung"))
    println(describeProfile("Budi", null))
    println(describeProfile(nama = "Citra", umur = 19))
}
