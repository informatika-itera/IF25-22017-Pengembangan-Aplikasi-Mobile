// Hands-on 3: Loops, Ranges & Null Safety
// Solusi: Menggunakan filterNotNull() untuk menghapus null, filter dan
// sortedDescending() untuk menyaring dan mengurutkan skor, serta range dengan step
// untuk menampilkan bilangan ganjil.

class ScoreBoard(private val skorMentah: List<Int?>) {
    // menyaring skor mentah agar hanya menyimpan nilai yang valid
    val skorValid: List<Int> = skorMentah.filterNotNull()

    fun skorKelulusan(batasLulus: Int): List<Int> {
        // menyaring kembali nilai yang memenuhi syarat dan mengurutkannya menurun
        return skorValid.filter { it >= batasLulus }.sortedDescending()
    }
}

fun cetakRentangGanjil(sampai: Int) {
    // melakukan iterasi dari 1 sampai step 2 hanya mengambil angka ganjil
    for (i in 1..sampai step 2) {
        print("$i ")
    }
    // membuat jarak
    print{}
}

fun main() {
    val papan = ScoreBoard(listOf(85, null, 72, 90, null, 55, 100))
    println("Skor lulus (>= 70): ${papan.skorKelulusan(70)}")

    cetakRentangGanjil(10)
}

// Output yang diharapkan:
// Skor lulus (>= 70): [100, 90, 85, 72]
// 1 3 5 7 9
