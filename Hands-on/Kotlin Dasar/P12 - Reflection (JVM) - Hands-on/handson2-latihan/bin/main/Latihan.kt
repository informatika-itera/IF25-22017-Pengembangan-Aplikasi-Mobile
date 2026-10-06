import kotlin.reflect.full.memberProperties

// Hands-on 2: Baca Nilai Property Dinamis
// Tugas: Buat fungsi generik `printFields(obj: Any)` yang mencetak SEMUA
// nama dan nilai property dari objek apapun yang diberikan, mirip seperti
// toString() otomatis — tanpa hardcode nama field satupun.

data class Mahasiswa(val nim: String, val nama: String, val ipk: Double)

fun printFields(obj: Any) {
    // TODO 1: Ambil KClass dari obj (gunakan obj::class)
    // TODO 2: Iterasi memberProperties dari KClass tersebut
    // TODO 3: Untuk setiap property, panggil property.getter.call(obj)
    //         untuk mendapatkan nilainya, lalu cetak "namaProperty = nilai"

    // Kode kamu di sini...
}

fun main() {
    val mhs = Mahasiswa("122140000", "Budi Santoso", 3.75)
    printFields(mhs)

    // Output yang diharapkan (urutan boleh berbeda):
    // nim = 122140000
    // nama = Budi Santoso
    // ipk = 3.75
}
