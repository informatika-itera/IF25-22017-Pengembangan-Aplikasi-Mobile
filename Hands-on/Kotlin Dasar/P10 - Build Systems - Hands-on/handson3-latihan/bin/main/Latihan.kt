import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

// File ini SENGAJA belum bisa di-compile — import kotlinx.datetime di atas
// akan error sampai kamu melengkapi TODO di build.gradle.kts module ini
// dengan mendeklarasikan dependency "kotlinx-datetime".

fun main() {
    val now = Clock.System.now()
    val today = now.toLocalDateTime(TimeZone.currentSystemDefault()).date
    println("Hari ini: $today")
}
