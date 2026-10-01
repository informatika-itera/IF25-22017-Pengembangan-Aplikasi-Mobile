// Hands-on 3: Sealed Class untuk State
// Tugas: Modelkan hasil pemanggilan network sebagai sealed class NetworkResult
// dengan 3 kemungkinan state: Loading, Success (membawa data), dan Error (membawa pesan).
//
// CATATAN: File ini belum bisa di-compile sampai kamu melengkapi semua TODO
// di bawah — itu normal untuk latihan ini!

/**
 * Status hasil pengambilan data dari internet.
 * Bisa berupa sedang memuat (Loading), berhasil (Success), atau gagal (Error).
 */
sealed class NetworkResult

object Loading : NetworkResult()

data class Success(val data: String) : NetworkResult()

data class Error(val message: String) : NetworkResult()

/**
 * Memberikan keterangan teks yang mudah dibaca pengguna berdasarkan status hasil.
 */
fun describe(result: NetworkResult): String {
    return when (result) {
        is Loading -> "Sedang memuat..."
        is Success -> "Berhasil: ${result.data}"
        is Error -> "Gagal: ${result.message}"
    }
}

fun main() {
    println(describe(Loading))
    println(describe(Success("Data pengguna berhasil diambil")))
    println(describe(Error("Koneksi terputus")))
}
