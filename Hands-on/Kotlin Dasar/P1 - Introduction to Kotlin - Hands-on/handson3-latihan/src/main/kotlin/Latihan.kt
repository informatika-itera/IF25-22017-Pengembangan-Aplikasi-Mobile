// Hands-on 3: Loops, Ranges & Null Safety
// Tugas: Lengkapi ScoreBoard agar bisa menyaring skor yang valid (bukan null)
// dan berada dalam batas kelulusan, lalu tampilkan bilangan ganjil dengan loop.
//
// CATATAN: File ini belum bisa dijalankan (belum bisa di-compile) sampai kamu
// melengkapi semua TODO di bawah — itu normal untuk latihan ini!

/**
 * Papan skor untuk memilah dan merapikan nilai peserta.
 */
class ScoreBoard(private val skorMentah: List<Int?>) {
    val skorValid: List<Int> = skorMentah.filterNotNull()

    /**
     * Memilih skor yang lolos nilai minimal, lalu mengurutkannya dari yang terbesar.
     */
    fun skorKelulusan(batasLulus: Int): List<Int> {
        return skorValid.filter { it >= batasLulus }.sortedDescending()
    }
}

/**
 * Mencetak kumpulan angka ganjil secara berurutan.
 */
fun cetakRentangGanjil(sampai: Int) {
    for (i in 1..sampai step 2) {
        print("$i ")
    }
    println()
}

fun main() {
    val papan = ScoreBoard(listOf(85, null, 72, 90, null, 55, 100))
    println("Skor lulus (>= 70): ${papan.skorKelulusan(70)}")

    cetakRentangGanjil(10)
}

// Output yang diharapkan:
// Skor lulus (>= 70): [100, 90, 85, 72]
// 1 3 5 7 9
