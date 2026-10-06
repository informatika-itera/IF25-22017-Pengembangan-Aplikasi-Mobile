import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

// Hands-on 3: Request Handling & Status Code
// Tugas:
//   1. Handle POST /echo — baca body request, lalu kembalikan body yang
//      sama persis sebagai response (status 200).
//   2. Tambahkan handler default ("/") yang mengembalikan status 404
//      Not Found untuk semua path yang tidak dikenal.
//
// CATATAN: File ini SENGAJA belum bisa di-compile sampai kamu melengkapi
// semua TODO di bawah — itu normal untuk latihan ini!

fun main() {
    val server = HttpServer.create(InetSocketAddress("0.0.0.0", 8080), 0)

    server.createContext("/echo") { exchange ->
        if (exchange.requestMethod != "POST") {
            // TODO 1: Kirim status 405 Method Not Allowed (body kosong,
            // pakai sendResponseHeaders(405, -1) lalu return)
        }

        // TODO 2: Ganti baris di bawah ini dengan kode yang membaca seluruh isi
        // exchange.requestBody menjadi ByteArray (gunakan exchange.requestBody.readBytes())
        val requestBytes: ByteArray = belumDiimplementasikan

        // TODO 3: Kirim balik requestBytes sebagai response body,
        // dengan status 200
    }

    server.createContext("/") { exchange ->
        // TODO 4: Ini handler default untuk semua path yang tidak match
        // context lain (mis. "/foo", "/bar"). Kirim status 404 Not Found
        // dengan body teks "Not Found: <path>" (ambil path dari
        // exchange.requestURI.path)
    }

    server.start()
    println("Server berjalan di http://localhost:8080")
    println("Coba: curl -X POST -d 'halo dunia' http://localhost:8080/echo")
    println("Coba: curl -i http://localhost:8080/tidak-ada")

    Thread.sleep(10_000)
    server.stop(0)
    println("Server dihentikan")
}
