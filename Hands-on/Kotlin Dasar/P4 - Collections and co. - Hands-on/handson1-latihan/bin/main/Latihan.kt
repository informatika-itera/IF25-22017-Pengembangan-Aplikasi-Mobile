// Hands-on 1: Transformasi Collection
// Tugas: Dari daftar produk, tampilkan NAMA produk yang harganya di atas
// sebuah threshold, terurut dari yang termurah ke termahal.
// Konsep: filter, map, sortedBy

data class Product(val nama: String, val harga: Int, val stok: Int)

/**
 * Mencari daftar nama produk yang harganya di atas batas tertentu, 
 * lalu mengurutkannya mulai dari yang paling murah.
 */
fun produkDiAtasHarga(produk: List<Product>, minHarga: Int): List<String> {
    return produk.filter { it.harga > minHarga }
                 .sortedBy { it.harga }
                 .map { it.nama }
}

fun main() {
    val katalog = listOf(
        Product("Mouse Wireless", 75_000, 20),
        Product("Keyboard Mechanical", 450_000, 5),
        Product("Monitor 24 inch", 1_500_000, 3),
        Product("USB Flashdisk 32GB", 60_000, 50),
        Product("Webcam HD", 250_000, 8)
    )

    val hasil = produkDiAtasHarga(katalog, 100_000)
    println("Produk dengan harga di atas Rp100.000 (termurah dulu):")
    println(hasil)
    // Expected: [Webcam HD, Keyboard Mechanical, Monitor 24 inch]
}
