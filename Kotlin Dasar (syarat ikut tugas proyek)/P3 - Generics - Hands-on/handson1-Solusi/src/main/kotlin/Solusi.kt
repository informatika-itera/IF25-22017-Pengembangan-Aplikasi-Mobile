// Hands-on 1: Generic Class — Box<T>
// Solusi: Menggunakan generic class dan fungsi map<R> untuk mengubah tipe isi Box
// tanpa mengubah Box yang asli.

class Box<T>(val value: T) {
    // yang mengembalikan Box<R> baru berisi hasil transform(value)
    fun <R> map(transform: (T) -> R): Box<R> {
    return Box(transform(value))
    }
}

fun main() {
    val intBox = Box(23)
    println("intBox.value = ${intBox.value}")

    val cupBox = Box("cup") // Tipe parameter bisa di-infer
    println("cupBox.value = ${cupBox.value}")

    // Mentransformasikan Box<Int> menjadi Box<String> menggunakan fungsi map
    val stringBox = intBox.map { "Angka: $it" }
    println("stringBox.value = ${stringBox.value}")

    // Mentransformasikan Box<String> menjadi Box<Int> berisi panjang karakter string
    val lengthBox = cupBox.map { it.length }
    println("lengthBox.value = ${lengthBox.value}")
}
