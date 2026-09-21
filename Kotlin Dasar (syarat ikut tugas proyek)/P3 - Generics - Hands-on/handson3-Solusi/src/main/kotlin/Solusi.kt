// Hands-on 3: Variance — declaration-site "out"
// Solusi: Menggunakan modifier "out" (covariance) karena tipe parameter hanya sebagai producer

open class Animal(val name: String)
class Cat(name: String) : Animal(name)

// Tambahkan modifier 'out' agar tipe bersifat covariant (Container<Cat> adalah subtipe Container<Animal>)
interface Container<out T> {
    fun get(): T
}

//Implementasikan container khusus untuk tipe turunan Cat
class CatContainer(private val cat: Cat) : Container<Cat> {
    override fun get(): Cat = cat
}

// Fungsi ini menerima Container<Animal>
// Berkat modifier 'out T', Container<Cat> kini valid diperlakukan sebagai subtipe dari Container<Animal>
fun printAnimalName(container: Container<Animal>) {
    println("Nama hewan: ${container.get().name}")
}
fun main() {
    val catContainer: Container<Cat> = CatContainer(Cat("Whiskers"))
    printAnimalName(catContainer)
}
