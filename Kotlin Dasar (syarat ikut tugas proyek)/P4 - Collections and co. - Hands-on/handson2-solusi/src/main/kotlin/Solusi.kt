// Hands-on 2: Grouping & Aggregation
// Solusi: Menggunakan groupBy dan mapValues untuk menghitung total per kategori,
// serta associateBy untuk mencari transaksi berdasarkan ID.

data class Transaksi(val id: String, val kategori: String, val nominal: Int)

fun totalPerKategori(transaksi: List<Transaksi>): Map<String, Int> {
    // Mengelompokkan transaksi dan menghitung total nominal tiap kategori
    return transaksi
        // Mengelompokkan transaksi berdasarkan kategori
        .groupBy { it.kategori }
        // Menjumlahkan nominal dari setiap kategori
        .mapValues { (_, daftarTransaksi) -> daftarTransaksi.sumOf { it.nominal } }
}

fun transaksiById(transaksi: List<Transaksi>): Map<String, Transaksi> {
    // Mengubah list transaksi menjadi Map dengan ID sebagai key
    return transaksi.associateBy { it.id }
}

fun main() {
    val transaksi = listOf(
        Transaksi("TRX01", "Makanan", 50_000),
        Transaksi("TRX02", "Transportasi", 20_000),
        Transaksi("TRX03", "Makanan", 35_000),
        Transaksi("TRX04", "Hiburan", 100_000),
        Transaksi("TRX05", "Transportasi", 15_000)
    )

    println("Total per kategori: ${totalPerKategori(transaksi)}")

    val byId = transaksiById(transaksi)
    println("Cari TRX03: ${byId["TRX03"]}")
}
