// Hands-on 2: Grouping & Aggregation
// Tugas: Dari daftar transaksi, hitung total nominal per kategori.
// Konsep: groupBy, sumOf, associateBy, Map

data class Transaksi(val id: String, val kategori: String, val nominal: Int)

/**
 * Mengelompokkan transaksi per kategori dan menghitung total uang pada masing-masing kategori.
 */
fun totalPerKategori(transaksi: List<Transaksi>): Map<String, Int> {
    return transaksi.groupBy { it.kategori }
                    .mapValues { entry -> entry.value.sumOf { it.nominal } }
}

/**
 * Membuat kamus transaksi agar mudah dicari berdasarkan nomor ID-nya.
 */
fun transaksiById(transaksi: List<Transaksi>): Map<String, Transaksi> {
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
    // Expected: {Makanan=85000, Transportasi=35000, Hiburan=100000}

    val byId = transaksiById(transaksi)
    println("Cari TRX03: ${byId["TRX03"]}")
    // Expected: Transaksi(id=TRX03, kategori=Makanan, nominal=35000)
}
