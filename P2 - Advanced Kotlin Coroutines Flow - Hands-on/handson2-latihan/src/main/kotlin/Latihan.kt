import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

// Hands-on 2: Flow dengan Operators
// Tugas: Buat Flow yang mensimulasikan sensor suhu, filter suhu di atas 30°C,
// dan tampilkan warning dengan format yang bagus.

fun temperatureSensor(): Flow<Int> = flow {
    repeat(10) {
        delay(500)
        val temp = Random.nextInt(20, 40) // Random 20-39°C
        emit(temp)
    }
}

fun main() = runBlocking {
    temperatureSensor()
        // 1. Filter suhu > 30°C saja
        .filter { it > 30 }
        
        // 2. Transform (map) menjadi string warning
        .map { "⚠️ WARNING: Suhu tinggi terdeteksi: $it°C" }
        
        // 3. Tampilkan setiap warning dengan collect
        .collect { warning -> 
            println(warning) 
        }
}