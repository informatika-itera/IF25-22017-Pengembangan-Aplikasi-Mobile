// Hands-on 1: Class & Inheritance
// Tugas: Buat hierarki class kendaraan menggunakan open class, primary constructor,
// dan override fungsi. Vehicle adalah base class, Car dan Motorcycle adalah turunannya.

// TODO 1: Jadikan class ini "open" agar bisa diturunkan (inherited).
// Primary constructor sudah punya property name (val) dan maxSpeed (val, dalam km/h).
/**
 * Kendaraan umum yang memiliki nama dan kecepatan maksimal.
 */
open class Vehicle(val name: String, val maxSpeed: Int) {
    open fun describe(): String {
        return "$name dapat melaju hingga $maxSpeed km/h"
    }
}

/**
 * Mobil, jenis kendaraan yang dilengkapi dengan informasi jumlah pintu.
 */
class Car(name: String, val numberOfDoors: Int) : Vehicle(name, 180) {
    override fun describe(): String {
        return "$name dapat melaju hingga $maxSpeed km/h dan punya $numberOfDoors pintu"
    }
}

/**
 * Sepeda motor, jenis kendaraan yang bisa dilengkapi keranjang samping.
 */
class Motorcycle(name: String, val hasSidecar: Boolean) : Vehicle(name, 220) {
    override fun describe(): String {
        val sidecarInfo = if (hasSidecar) "dengan sidecar" else "tanpa sidecar"
        return "$name dapat melaju hingga $maxSpeed km/h ($sidecarInfo)"
    }
}

fun main() {
    val vehicles = listOf<Vehicle>(
        Car("Toyota", numberOfDoors = 4),
        Motorcycle("Ninja", hasSidecar = false)
    )

    // Polymorphism: setiap elemen dipanggil lewat interface Vehicle,
    // tapi describe() yang jalan adalah versi milik subclass masing-masing.
    vehicles.forEach { println(it.describe()) }
}
