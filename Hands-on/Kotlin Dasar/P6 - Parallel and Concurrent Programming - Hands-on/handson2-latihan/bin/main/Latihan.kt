import java.util.concurrent.Callable
import java.util.concurrent.Executors

// Hands-on 2: ExecutorService & Future
// Tugas: Jalankan 4 "task" perhitungan yang lambat (simulasi delay dengan
// Thread.sleep) secara PARALEL menggunakan thread pool, lalu kumpulkan semua
// hasilnya. Jika dijalankan sequential, total waktu ~4 detik. Dengan thread
// pool 4 pekerja, seharusnya total waktu ~1 detik.

fun hitungKuadrat(n: Int): Int {
    Thread.sleep(1000) // Simulasi kerja berat
    return n * n
}

fun main() {
    val angka = listOf(1, 2, 3, 4)
    val startTime = System.currentTimeMillis()

    // TODO 1: Buat ExecutorService dengan Executors.newFixedThreadPool(4)
    // val executor = ???

    // TODO 2: Submit satu Callable per angka ke executor, simpan Future-nya
    // val futures = angka.map { n -> executor.submit(Callable { hitungKuadrat(n) }) }

    // TODO 3: Ambil semua hasil dengan future.get(), lalu tampilkan
    // val hasil = futures.map { it.get() }
    // println("Hasil: $hasil")

    // TODO 4: Jangan lupa shutdown() executor supaya program bisa berhenti (JVM
    // tidak akan exit selama thread pool masih hidup)

    val endTime = System.currentTimeMillis()
    println("Waktu: ${endTime - startTime}ms")
}
