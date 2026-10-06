// Hands-on 2: Interface & Data Class
// Tugas: Buat interface Payable dengan fungsi calculateSalary(), lalu implementasikan
// lewat data class Employee. Manfaatkan fitur bawaan data class: toString(), equals(),
// dan copy().

/**
 * Kontrak atau acuan untuk hal-hal yang gajinya bisa dihitung.
 */
interface Payable {
    fun calculateSalary(): Double
}

/**
 * Data pegawai yang menyimpan nama, gaji pokok, dan tambahan bonus.
 */
data class Employee(val name: String, val baseSalary: Double, val bonus: Double) : Payable {

    override fun calculateSalary(): Double {
        return baseSalary + bonus
    }
}

fun main() {
    val alice = Employee("Alice", baseSalary = 5_000_000.0, bonus = 500_000.0)

    val bob = alice.copy(name = "Bob")

    println("Gaji ${alice.name}: ${alice.calculateSalary()}")
    println("Gaji ${bob.name}: ${bob.calculateSalary()}")

    val aliceDuplicate = alice.copy()
    println("alice == aliceDuplicate? ${alice == aliceDuplicate}")

    // toString() bawaan data class akan mencetak semua property secara otomatis.
    println(alice)
}
