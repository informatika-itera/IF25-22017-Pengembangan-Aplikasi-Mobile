// Hands-on 2: Bounded Type Parameter
// Solusi: Pencarian nilai maksimum dengan constraint Comparable<T>

fun <T : Comparable<T>> findMax(items: List<T>): T {

    // Memeriksa apakah list kosong; jika ya, lemparkan IllegalArgumentException
    if (items.isEmpty()) {
        throw IllegalArgumentException("List tidak boleh kosong")
    }

    // Menginisialisasi variabel max sementara dengan elemen pertama list
    var max = items[0]
    // Melakukan perulangan untuk setiap elemen di dalam list
    for (item in items) {
        if (item.compareTo(max) > 0) {
            max = item
        }
    }
    // Mengembalikan nilai elemen terbesar yang ditemukan
    return max
}

fun main() {
    println(findMax(listOf(3, 7, 2, 9, 4)))              // 9
    println(findMax(listOf(1.5, 2.8, 0.3)))            // 2.8
    println(findMax(listOf("apel", "jeruk", "duku")))   // "jeruk"
}