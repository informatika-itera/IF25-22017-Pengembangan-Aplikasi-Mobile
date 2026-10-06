// Hands-on 1: Generic Class — Box<T>
// Tugas: Lengkapi class generik Box<T> yang menyimpan satu nilai bertipe T,
// lalu tambahkan fungsi map<R> yang mengubah isi Box menjadi Box<R> baru
// menggunakan fungsi transformasi, tanpa mengubah Box aslinya.

/**
 * Kotak serbaguna untuk menyimpan satu nilai apa saja.
 */
class Box<T>(val value: T) {
    /**
     * Membuka isi kotak ini, mengubahnya menjadi bentuk lain, lalu menyimpannya di kotak baru.
     */
    fun <R> map(transform: (T) -> R): Box<R> {
        return Box(transform(value))
    }
}

fun main() {
    val intBox = Box(23)
    println("intBox.value = ${intBox.value}")

    val cupBox = Box("cup") // Tipe parameter bisa di-infer
    println("cupBox.value = ${cupBox.value}")

    val stringBox = intBox.map { "Angka: $it" }
    println("stringBox.value = ${stringBox.value}")

    val lengthBox = cupBox.map { it.length }
    println("lengthBox.value = ${lengthBox.value}")
}
