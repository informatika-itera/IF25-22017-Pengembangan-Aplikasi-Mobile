// Hands-on 2: Tailrec Optimization
//
// Konteks: Setiap pemanggilan fungsi biasa di JVM menambah satu STACK FRAME
// baru ke call stack thread (memori non-heap, ukurannya kecil — sekitar
// 1024 KB per thread). Fungsi rekursif biasa yang dipanggil ribuan/jutaan
// kali akan menumpuk stack frame terus-menerus sampai StackOverflowError.
//
// Kotlin compiler bisa mengoptimasi fungsi rekursif TERTENTU (rekursi di
// posisi terakhir / "tail call") menjadi LOOP biasa di level bytecode —
// tanpa menambah stack frame sama sekali — asalkan diberi keyword `tailrec`.
//
// Tugas: factorialBiasa() di bawah akan StackOverflowError untuk n besar.
// Buat versi yang aman menggunakan `tailrec`.

fun factorialBiasa(n: Long, acc: Long = 1): Long {
    if (n <= 1) return acc
    return factorialBiasa(n - 1, acc * n) // rekursi di posisi terakhir (tail call)
}

// TODO 1: Tambahkan modifier `tailrec` pada fungsi ini
// TODO 2: Pastikan bentuknya sama seperti factorialBiasa() di atas —
//         syarat tailrec: pemanggilan rekursif harus jadi ekspresi TERAKHIR
//         yang dieksekusi (tidak boleh ada operasi lain setelah hasil rekursi)
fun factorialTailrec(n: Long, acc: Long = 1): Long {
    TODO("Lengkapi implementasi factorialTailrec() dengan pola yang sama seperti factorialBiasa()")
}

fun main() {
    println("factorialBiasa(20) = ${factorialBiasa(20)}") // aman, n kecil

    println("factorialTailrec(20) = ${factorialTailrec(20)}")

    // Uji dengan n besar: factorialBiasa akan StackOverflowError,
    // factorialTailrec harus tetap aman (walau hasilnya overflow Long, tidak apa).
    try {
        println("factorialBiasa(100000) = ${factorialBiasa(100000)}")
    } catch (e: StackOverflowError) {
        println("factorialBiasa(100000) -> StackOverflowError! (dibatasi ukuran stack JVM)")
    }

    println("factorialTailrec(100000) = ${factorialTailrec(100000)} (tidak overflow stack)")
}
