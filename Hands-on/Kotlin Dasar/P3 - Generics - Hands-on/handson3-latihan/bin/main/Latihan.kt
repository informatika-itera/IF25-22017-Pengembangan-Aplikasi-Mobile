// Hands-on 3: Variance — declaration-site "out"
// Tugas: interface Container<T> di bawah HANYA memproduksi T (fun get(): T),
// tidak pernah mengonsumsinya. Tandai T dengan modifier variance yang tepat
// agar Container<Cat> bisa dianggap sebagai subtipe dari Container<Animal>.
//
// CATATAN: File ini SENGAJA tidak bisa di-compile sebelum TODO diisi
// (fungsi assignToAnimalContainer akan gagal type-check) — itu bagian dari
// latihan untuk merasakan langsung error [TYPE_MISMATCH] akibat invariance.

open class Animal(val name: String)
class Cat(name: String) : Animal(name)

// TODO 1: Tambahkan modifier variance yang tepat pada T di sini
/**
 * Wadah yang hanya bisa digunakan untuk mengambil data dari dalamnya.
 */
interface Container<out T> {
    fun get(): T
}

class CatContainer(private val cat: Cat) : Container<Cat> {
    override fun get(): Cat = cat
}

// Baris ini butuh Container<Cat> dianggap sebagai Container<Animal>.
// Tanpa modifier yang tepat pada T di atas, baris ini akan gagal
// dengan error: Type mismatch. Required: Container<Animal>. Found: Container<Cat>.
fun printAnimalName(container: Container<Animal>) {
    println("Nama hewan: ${container.get().name}")
}

fun main() {
    val catContainer: Container<Cat> = CatContainer(Cat("Whiskers"))

    // TODO 2: Setelah TODO 1 benar, baris berikut akan bisa di-compile
    printAnimalName(catContainer)
}
