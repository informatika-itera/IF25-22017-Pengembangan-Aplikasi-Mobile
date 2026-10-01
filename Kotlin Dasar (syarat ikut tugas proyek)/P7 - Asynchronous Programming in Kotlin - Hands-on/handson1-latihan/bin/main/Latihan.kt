import kotlinx.coroutines.*

// Hands-on 1: Suspend Function Dasar
// Tugas: Buat suspend function checkOrderStatus() yang mensimulasikan
// panggilan ke server untuk mengecek status pesanan (delay 2 detik),
// lalu panggil dari dalam coroutine sehingga main thread TIDAK ter-blok
// selama menunggu.
//
// Ingat: "One cannot just walk into a suspending function" — suspend fun
// hanya boleh dipanggil dari coroutine (launch/runBlocking/async) atau
// dari suspend fun lain.

suspend fun checkOrderStatus(orderId: String): String {
    // TODO 1: Simulasikan network delay 2000ms dengan delay()
    // TODO 2: Kembalikan String "Order $orderId: SHIPPED"
    TODO("Lengkapi checkOrderStatus")
}

fun main() = runBlocking {
    // TODO 3: Panggil checkOrderStatus("A100") dari dalam coroutine ini
    //         (runBlocking sendiri adalah CoroutineScope, jadi bisa langsung
    //         memanggil suspend fun di sini).
    // TODO 4: Sebelum menunggu hasilnya, cetak dulu "Menunggu status pesanan..."
    //         supaya terlihat bahwa program tetap berjalan (tidak blocking thread).

    println("Menunggu status pesanan...")

    // Kode kamu di sini...
}
