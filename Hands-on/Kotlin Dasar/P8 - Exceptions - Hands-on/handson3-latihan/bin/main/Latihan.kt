// Hands-on 3: Kotlin Sugar - try sebagai expression, require(), error(), multi-catch
// Tugas: Buat parser tiket sederhana dari format teks "nama/umur",
// misalnya "Budi/25", menggunakan gaya penanganan error khas Kotlin.
//
// CATATAN: file ini SENGAJA belum bisa di-compile sebelum semua TODO
// dilengkapi - itu bagian dari latihan ini.

data class Tiket(val nama: String, val umur: Int)

fun parseTiket(input: String): Tiket {
    val bagian = input.split("/")

    // TODO 1: Gunakan require() untuk memastikan bagian.size == 2,
    //         jika tidak, lempar IllegalArgumentException dengan pesan
    //         "Format harus 'nama/umur', diterima: $input"

    val nama = bagian[0]

    // TODO 2: Gunakan `try { ... } catch (e: NumberFormatException) { ... }`
    //         SEBAGAI EXPRESSION (try mengembalikan nilai) untuk mengubah
    //         bagian[1] menjadi Int bernama `umur`. Jika gagal parsing,
    //         panggil error("Umur tidak valid: ${bagian[1]}") di blok catch
    //         (error() melempar IllegalStateException).
    val umur: Int = ??? // <-- ganti dengan try-as-expression di atas, ini sengaja error compile

    // TODO 3: Gunakan require() lagi untuk memastikan umur >= 0 dan nama
    //         tidak kosong, dengan pesan error yang sesuai.

    return Tiket(nama, umur)
}

fun main() {
    val inputs = listOf("Budi/25", "Siti/17", "format-salah", "Andi/bukan-angka", "/30")

    for (input in inputs) {
        // TODO 4: Panggil parseTiket(input) di dalam try-catch dengan
        //         BEBERAPA blok catch (multi-catch) untuk menangani
        //         IllegalArgumentException dan IllegalStateException secara
        //         terpisah, lalu cetak hasil atau pesan errornya.
        println(parseTiket(input))
    }
}
