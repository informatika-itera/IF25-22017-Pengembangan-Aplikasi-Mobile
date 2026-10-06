// Hands-on 3: Closure — Counter Factory
// Tugas: Implementasikan `makeCounter()` yang mengembalikan sebuah fungsi
// closure. Setiap kali closure tersebut dipanggil, ia harus mengembalikan
// angka berikutnya (1, 2, 3, ...) dengan MENGINGAT state count-nya sendiri
// di luar scope fungsi `makeCounter`.
//
// CATATAN: File ini SENGAJA belum bisa di-compile sampai kamu melengkapi
// semua TODO di bawah — itu normal untuk latihan ini!

/**
 * Membuat mesin penghitung mandiri.
 * Setiap kali digunakan, ia akan memberikan angka yang berurutan.
 */
fun makeCounter(): () -> Int {
    var count = 0
    return {
        count++
        count
    }
}

fun main() {
    val counterA = makeCounter()
    val counterB = makeCounter()

    println(counterA()) // 1
    println(counterA()) // 2
    println(counterA()) // 3

    println(counterB()) // 1 (counterB independen dari counterA)
    println(counterB()) // 2
}
