// Hands-on 1: Class & Inheritance
// Solusi: Menggunakan open class untuk inheritance, override untuk mengubah
// fungsi describe(), serta membuat Car dan Motorcycle sebagai turunan Vehicle.

// Primary constructor sudah punya property name (val) dan maxSpeed (val, dalam km/h).
open class Vehicle(val name: String, val maxSpeed: Int) {

    open fun describe(): String {
        return "$name dapat melaju hingga $maxSpeed km/h"
    }
}

// Membuat class Car sebagai turunan dari Vehicle dan menambahkan jumlah pintu.
// maxSpeed diatur 180 km/h, lalu describe() di-override untuk menampilkan info mobil.
class Car(name: String, val numberOfDoors: Int) : Vehicle(name, 180) {
    override fun describe(): String {
        return "$name dapat melaju hingga $maxSpeed km/h dan punya $numberOfDoors pintu"
    }
}

// Membuat Motorcycle sebagai turunan dari Vehicle dengan tambahan sidecar.
// describe() di-override untuk menampilkan apakah motor memiliki sidecar atau tidak.
class Motorcycle(name: String, val hasSidecar: Boolean) : Vehicle(name, 220) {
    override fun describe(): String {
        return if (hasSidecar) {
            "$name dapat melaju hingga $maxSpeed km/h (dengan sidecar)"
        } else {
            "$name dapat melaju hingga $maxSpeed km/h (tanpa sidecar)"
        }
    }
}

fun main() {
    // Membuat list Vehicle yang berisi 1 mobil dan 1 motor.
    val vehicles = listOf<Vehicle>(
        Car("Land-Cruiser", numberOfDoors = 4),
        Motorcycle("ZX-25", hasSidecar = false)
    )

    // Polymorphism: setiap elemen dipanggil lewat interface Vehicle,
    // tapi describe() yang jalan adalah versi milik subclass masing-masing.
    vehicles.forEach { println(it.describe()) }
}

