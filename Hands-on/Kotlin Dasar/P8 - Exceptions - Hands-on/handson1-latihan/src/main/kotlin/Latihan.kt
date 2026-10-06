// Hands-on 1: Try-Catch-Finally Dasar
// Tugas: Lengkapi fungsi safeDivide agar menangani pembagian dengan nol
// menggunakan try-catch-finally, tanpa membuat program crash.

fun safeDivide(a: Int, b: Int): Int {
    // TODO 1: Bungkus pembagian a / b di dalam blok try
    // TODO 2: Tangkap ArithmeticException, cetak pesan error yang jelas,
    //         lalu kembalikan 0 sebagai nilai default
    // TODO 3: Di blok finally, cetak "safeDivide($a, $b) selesai diproses"
    //         (finally HARUS tetap jalan baik sukses maupun error)

    return a / b // <-- baris ini akan melempar ArithmeticException saat b == 0
}

fun main() {
    println("Hasil 1: ${safeDivide(10, 2)}")  // sukses -> 5
    println("Hasil 2: ${safeDivide(10, 0)}")  // b == 0 -> harus ditangani, hasil 0
    println("Hasil 3: ${safeDivide(9, 3)}")   // sukses -> 3
}
