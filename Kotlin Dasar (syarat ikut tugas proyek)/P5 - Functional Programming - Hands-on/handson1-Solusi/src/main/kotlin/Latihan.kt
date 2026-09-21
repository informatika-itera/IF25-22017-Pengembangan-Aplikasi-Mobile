// Hands-on 1: Higher-Order Function
// Solusi: Menggunakan fungsi tingkat tinggi (Higher-Order Function) yang menerima parameter fungsi/lambda

fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    // Menjalankan fungsi parameter operation dengan argumen a dan b, lalu mengembalikan hasilnya
    return operation(a, b)
}

fun main() {
    val tambah = calculate(10, 4) { x, y -> x + y }

    // Memanggil calculate dengan trailing lambda untuk penambahan
    val tambah = calculate(10, 4) { x, y -> x + y }
    println("Tambah: $tambah")

    // Memanggil calculate dengan trailing lambda untuk pengurangan
    val kurang = calculate(10, 4) { x, y -> x - y }
    println("Kurang: $kurang")

    // Memanggil calculate dengan trailing lambda untuk perkalian
    val kali = calculate(10, 4) { x, y -> x * y }
    println("Kali: $kali")
}
