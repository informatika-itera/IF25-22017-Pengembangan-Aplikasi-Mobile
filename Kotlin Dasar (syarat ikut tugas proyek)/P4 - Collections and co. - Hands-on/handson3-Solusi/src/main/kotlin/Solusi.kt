// Hands-on 3: Sequence vs List (Lazy Evaluation)
// Tugas: Bandingkan List (eager) vs Sequence (lazy) saat memproses data besar

// Solusi: List memproses data secara eager, sedangkan Sequence memproses data
// secara lazy sehingga pipeline bisa berhenti setelah mendapatkan 5 hasil.

fun prosesDenganList(data: List<Int>): List<Int> {
    //Memfilter angka genap, menguadratkan nilainya, dan mengambil 5 hasil pertama.
    return data
        .filter { it % 2 == 0 }
        .map { it * it }
        .take(5)
}

fun prosesDenganSequence(data: List<Int>): List<Int> {
    //Mengubah data menjadi Sequence, memfilter angka genap, menguadratkan,dan mengambil 5 hasil pertama secara lazy.
    return data
        .asSequence()
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

}
