// Hands-on 2: Interface & Data Class
// Solusi: Menggunakan interface untuk fungsi calculateSalary(), data class untuk Employee,
// serta copy() dan equals() untuk menyalin dan membandingkan isi objek.

// Interface Payable yang mendefinisikan kontrak fungsi hitung gaji tanpa menyimpan state
interface Payable {
    // (Interface tidak bisa punya state, tapi bisa punya fungsi abstrak.)
    fun calculateSalary(): Double
}

// Data class otomatis menyediakan fungsi equals(), hashCode(), toString(), dan copy()
data class Employee(val name: String, val baseSalary: Double, val bonus: Double) : Payable {

    override fun calculateSalary(): Double {
        return baseSalary + bonus
    }
}

fun main() {
    val alice = Employee("Alice", baseSalary = 5_000_000.0, bonus = 500_000.0)

    // Menggunakan fitur copy() untuk menduplikasi objek alice dan hanya mengubah properti name menjadi Bob
    val bob = alice.copy(name = "Bob")

    println("Gaji ${alice.name}: ${alice.calculateSalary()}")
    println("Gaji ${bob.name}: ${bob.calculateSalary()}")

    // Membuat salinan alice dengan data yang sama, lalu membandingkan isi keduanya.
    val aliceDuplicate = alice.copy()
    println("alice == aliceDuplicate? ${alice == aliceDuplicate}")

    // toString() bawaan data class akan mencetak semua property secara otomatis.
    println(alice)
}
