// Hands-on 1: Higher-Order Function
// Tugas: Lengkapi fungsi `calculate` yang menerima dua angka dan sebuah
// fungsi `operation` (Int, Int) -> Int, lalu jalankan `operation` terhadap
// kedua angka tersebut. Panggil `calculate` dengan beberapa lambda berbeda
// (tambah, kurang, kali) tanpa mengubah signature-nya.

/**
 * Melakukan perhitungan (tambah, kurang, dsb) pada dua buah angka.
 */
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

    val tambah = calculate(10, 4) { x, y -> x + y }
    println("Tambah: $tambah")

    val kurang = calculate(10, 4) { x, y -> x - y }
    println("Kurang: $kurang")

    val kali = calculate(10, 4) { x, y -> x * y }
    println("Kali: $kali")
}
