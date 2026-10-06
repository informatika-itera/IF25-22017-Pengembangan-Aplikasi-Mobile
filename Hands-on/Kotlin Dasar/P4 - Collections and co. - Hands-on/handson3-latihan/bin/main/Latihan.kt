// Hands-on 3: Sequence vs List (Lazy Evaluation)
// Tugas: Bandingkan List (eager) vs Sequence (lazy) saat memproses data besar
// dengan operasi filter + map berantai.
//
// CATATAN: File ini SENGAJA belum bisa dijalankan dengan benar sampai kamu
// melengkapi semua TODO — bagian "Kode kamu di sini" masih placeholder.

/**
 * Memproses daftar angka sekaligus. Mengambil angka genap, mengalikannya, lalu mengambil 5 angka pertama.
 * Cara ini sedikit memakan waktu karena semua data diproses sebelum diambil.
 */
fun prosesDenganList(data: List<Int>): List<Int> {
    return data.filter { it % 2 == 0 }
               .map { it * it }
               .take(5)
}

/**
 * Memproses daftar angka satu-per-satu.
 * Jauh lebih cepat karena proses otomatis berhenti ketika sudah mendapat 5 hasil.
 */
fun prosesDenganSequence(data: List<Int>): List<Int> {
    return data.asSequence()
               .filter { it % 2 == 0 }
               .map { it * it }
               .take(5)
               .toList()
}

fun main() {
    val data = (1..1_000_000).toList()

    val startList = System.currentTimeMillis()
    val hasilList = prosesDenganList(data)
    val waktuList = System.currentTimeMillis() - startList
    println("List  : $hasilList (${waktuList}ms)")

    val startSeq = System.currentTimeMillis()
    val hasilSequence = prosesDenganSequence(data)
    val waktuSequence = System.currentTimeMillis() - startSeq
    println("Sequence: $hasilSequence (${waktuSequence}ms)")

    // Expected: kedua hasil = [4, 16, 36, 64, 100], tapi Sequence jauh lebih
    // cepat karena tidak perlu membuat List perantara berukuran 1 juta elemen.
}
