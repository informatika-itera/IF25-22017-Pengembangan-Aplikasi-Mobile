import kotlinx.coroutines.*

// Hands-on 3: Structured Concurrency & Cancellation
// Tugas: Implementasikan DownloadManager yang men-download beberapa "file"
// (disimulasikan dengan delay) sebagai child coroutine dari satu Job. Jika
// Job tersebut dibatalkan (cancel), SEMUA child coroutine yang belum
// selesai harus ikut berhenti (ini yang disebut structured concurrency).
//
// CATATAN: File ini SENGAJA belum bisa di-compile sampai kamu melengkapi
// semua TODO di bawah — itu normal untuk latihan ini!

class DownloadManager(private val scope: CoroutineScope) {

    fun downloadFile(name: String, durationMs: Long): Job {
        // TODO 1: Gunakan scope.launch untuk membuat child coroutine baru.
        //         Di dalamnya:
        //         - delay(durationMs) untuk simulasi proses download
        //         - println("$name selesai di-download") setelah delay
        //         Kembalikan Job dari launch tersebut.
        // val job = ???
        // return job
    }
}

fun main() = runBlocking {
    // TODO 2: Buat sebuah Job induk (parent) baru dengan Job()
    // val parentJob = ???

    // TODO 3: Buat CoroutineScope baru dari parentJob tersebut
    //         (gunakan CoroutineScope(parentJob))
    // val scope = ???

    val manager = DownloadManager(scope)

    manager.downloadFile("foto.jpg", 1000)
    manager.downloadFile("video.mp4", 3000)
    manager.downloadFile("dokumen.pdf", 1500)

    delay(1200) // Beri waktu foto.jpg dan dokumen.pdf selesai

    println("Membatalkan sisa download...")
    // TODO 4: Batalkan parentJob dengan cancel() — video.mp4 (durasi 3000ms)
    //         seharusnya TIDAK sempat mencetak "selesai di-download".

    delay(2000) // Tunggu untuk membuktikan video.mp4 memang tidak selesai
    println("Selesai.")
}
