// Hands-on 3: Sealed Class untuk State
// Solusi: Menggunakan sealed class untuk mengatur state Loading, Success, dan Error dengan when.
// Sealed class NetworkResult untuk membatasi state yang ada
sealed class NetworkResult

// Loading digunakan saat data sedang dimuat dan tidak membawa data tambahan
object Loading : NetworkResult()

// Success digunakan saat berhasil dan membawa data hasil respon
data class Success(val data: String) : NetworkResult()

// Error digunakan saat terjadi kesalahan dan membawa pesan error
data class Error(val message: String) : NetworkResult()

// Fungsi describe untuk menentukan pesan berdasarkan state yang diterima
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
