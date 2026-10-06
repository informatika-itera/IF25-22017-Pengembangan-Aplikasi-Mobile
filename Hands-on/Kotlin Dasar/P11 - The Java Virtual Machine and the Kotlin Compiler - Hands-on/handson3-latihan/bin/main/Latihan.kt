// Hands-on 3: companion object & @JvmStatic
//
// Konteks: Secara default, fungsi di dalam `companion object` dikompilasi
// menjadi method INSTANCE pada sebuah inner class bernama Companion, BUKAN
// method static sungguhan di level JVM bytecode. Ini menyulitkan interop
// dengan Java/reflection Java biasa (java.lang.Class), yang mengharapkan
// method static ada langsung di kelas utama.
//
// Anotasi `@JvmStatic` memberi tahu Kotlin compiler backend untuk
// menghasilkan method static TAMBAHAN langsung di kelas utama (bukan hanya
// di Companion), sehingga bisa dipanggil dari Java seperti method static
// biasa.
//
// CATATAN: file ini SENGAJA tidak akan menunjukkan hasil yang benar sebelum
// TODO dilengkapi — bagian dari latihan ini adalah membuktikan sendiri lewat
// reflection java.lang.Class.

class Greeter {
    companion object {
        // TODO 1: Tambahkan anotasi @JvmStatic pada fungsi ini
        fun greet(name: String): String {
            return "Halo, $name!"
        }
    }
}

fun main() {
    println(Greeter.greet("Mahasiswa"))

    // Bukti lewat java.lang.Class reflection (BUKAN kotlin-reflect):
    // Tanpa @JvmStatic, method "greet" HANYA ada di Greeter.Companion.class,
    // TIDAK ada di Greeter.class secara langsung.
    val staticMethodNames = Greeter::class.java.methods.map { it.name }
    println("Method pada Greeter.class: $staticMethodNames")

    // TODO 2: Setelah menambahkan @JvmStatic di atas, baris ini harus mencetak true
    val punyaStaticGreet = staticMethodNames.contains("greet")
    println("Greeter.class punya static method 'greet'? $punyaStaticGreet")

    check(punyaStaticGreet) {
        "greet() belum jadi static method di Greeter.class — tambahkan @JvmStatic!"
    }
}
