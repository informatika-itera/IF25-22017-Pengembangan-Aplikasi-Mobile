import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

// Hands-on 3: Producer-Consumer dengan BlockingQueue
// Tugas: Implementasikan pola producer-consumer menggunakan LinkedBlockingQueue.
// Satu thread producer menaruh 5 pesan ke queue (dengan delay 200ms per pesan),
// satu thread consumer mengambil dan mencetak pesan itu satu per satu.
// Consumer harus berhenti setelah menerima tanda "selesai" dari producer.
//
// CATATAN: File ini belum bisa dijalankan (compile error) sampai kamu
// melengkapi semua TODO di bawah — itu normal untuk latihan ini!

const val PESAN_SELESAI = "SELESAI"

fun main() {
    // TODO 1: Buat LinkedBlockingQueue<String> untuk komunikasi antar thread
    // val queue = ???

    val producer = thread {
        for (i in 1..5) {
            val pesan = "Pesan #$i"
            // TODO 2: Masukkan pesan ke queue dengan queue.put(pesan)
            println("[Producer] mengirim: $pesan")
            Thread.sleep(200)
        }
        // TODO 3: Kirim PESAN_SELESAI ke queue sebagai tanda producer sudah selesai
    }

    val consumer = thread {
        while (true) {
            // TODO 4: Ambil pesan dari queue dengan queue.take() (blocking, menunggu jika queue kosong)
            // val pesan = ???

            // TODO 5: Jika pesan == PESAN_SELESAI, hentikan loop (break)
            // TODO 6: Jika bukan, cetak: println("[Consumer] menerima: $pesan")
        }
    }

    producer.join()
    consumer.join()
    println("Selesai!")
}
