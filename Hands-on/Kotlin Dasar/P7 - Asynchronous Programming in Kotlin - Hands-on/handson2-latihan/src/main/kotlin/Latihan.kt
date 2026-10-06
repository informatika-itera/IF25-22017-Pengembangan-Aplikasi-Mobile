import kotlinx.coroutines.*

// Hands-on 2: launch vs async
// Tugas: Ada 2 tugas simulasi — mencatat log (tidak perlu hasil) dan
// menghitung total harga belanja (perlu hasil untuk ditampilkan).
// Gunakan coroutine builder yang TEPAT untuk masing-masing:
// - launch  -> fire-and-forget, cocok untuk tugas yang tidak butuh nilai balik.
// - async   -> mengembalikan Deferred<T>, cocok kalau hasilnya dibutuhkan.

suspend fun writeAccessLog(message: String) {
    delay(500)
    println("[LOG] $message")
}

suspend fun calculateTotalPrice(prices: List<Int>): Int {
    delay(700)
    return prices.sum()
}

fun main() = runBlocking {
    val prices = listOf(15000, 25000, 10000)

    // TODO 1: Jalankan writeAccessLog("Checkout dimulai") dengan launch
    //         (kita tidak butuh return value-nya).

    // TODO 2: Jalankan calculateTotalPrice(prices) dengan async, simpan
    //         Deferred<Int>-nya ke sebuah variabel.

    // TODO 3: Ambil hasil total dari Deferred tersebut dengan await(),
    //         lalu cetak "Total belanja: Rp<total>".

    // Kode kamu di sini...
}
