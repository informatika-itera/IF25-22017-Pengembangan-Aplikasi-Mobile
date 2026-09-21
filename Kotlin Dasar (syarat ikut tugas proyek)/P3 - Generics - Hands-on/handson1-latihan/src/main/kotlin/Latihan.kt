    // Hands-on 1: Generic Class — Box<T>
    // Tugas: Lengkapi class generik Box<T> yang menyimpan satu nilai bertipe T,
    // lalu tambahkan fungsi map<R> yang mengubah isi Box menjadi Box<R> baru
    // menggunakan fungsi transformasi, tanpa mengubah Box aslinya.

    class Box<T>(val value: T) {
        // TODO 1: Tambahkan fungsi generik map<R>(transform: (T) -> R): Box<R>
        // yang mengembalikan Box<R> baru berisi hasil transform(value)

    }

    fun main() {
        val intBox = Box(23)
        println("intBox.value = ${intBox.value}")

        val cupBox = Box("cup") // Tipe parameter bisa di-infer
        println("cupBox.value = ${cupBox.value}")
    
        // TODO 2: Gunakan map untuk mengubah intBox (Box<Int>) menjadi Box<String>
        // berisi representasi string dari angkanya, misal "Angka: 23"
        // val stringBox = intBox.map { ... }
        // println("stringBox.value = ${stringBox.value}")

        // TODO 3: Gunakan map untuk mengubah cupBox (Box<String>) menjadi Box<Int>
        // berisi panjang string-nya
        // val lengthBox = cupBox.map { ... }
        // println("lengthBox.value = ${lengthBox.value}")
    }
