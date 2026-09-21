// Hands-on 1: Transformasi Collection
// Solusi: Menggunakan chaining fungsi collection filter, sortedBy, dan map

data class Product(val nama: String, val harga: Int, val stok: Int)

fun produkDiAtasHarga(produk: List<Product>, minHarga: Int): List<String> {
    return produk
        // Menyaring produk yang harganya melebihi batas minHarga
        .filter { it.harga > minHarga }
        // Menyaring produk yang lolos dari harga termurah ke termahal
        .sortedBy { it.harga }
        // Mengekstrak hanya nama produknya ke dalam List<String>
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
