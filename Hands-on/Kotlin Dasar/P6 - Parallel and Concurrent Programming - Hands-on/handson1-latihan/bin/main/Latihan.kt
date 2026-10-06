import kotlin.concurrent.thread

// Hands-on 1: Race Condition
// Tugas: Dua thread meng-increment sebuah shared counter (var c) sebanyak
// 100_000x masing-masing secara BERSAMAAN. Karena c++ bukan operasi atomik
// (baca-ubah-tulis, bisa saling menyela/interleave antar thread), hasil akhirnya
// SERING SALAH (bukan 200_000) — itulah race condition.
//
// TODO: Perbaiki class Counter di bawah supaya increment() aman dari race
// condition, sehingga hasil akhirnya SELALU 200_000 walau dijalankan berkali-kali.
// Gunakan salah satu: `synchronized(this) { }` ATAU `java.util.concurrent.atomic.AtomicInteger`.

class Counter {
    private var c = 0

    fun increment() {
        // TODO 1: Bungkus baris di bawah supaya thread-safe
        c++
    }

    fun value(): Int {
        // TODO 2: Jika kamu memakai AtomicInteger, sesuaikan cara membaca nilainya di sini
        return c
    }
}

fun main() {
    val counter = Counter()
    val iterasi = 100_000

    val t1 = thread {
        repeat(iterasi) { counter.increment() }
    }
    val t2 = thread {
        repeat(iterasi) { counter.increment() }
    }

    t1.join()
    t2.join()

    println("Hasil akhir: ${counter.value()} (seharusnya ${iterasi * 2})")
}
