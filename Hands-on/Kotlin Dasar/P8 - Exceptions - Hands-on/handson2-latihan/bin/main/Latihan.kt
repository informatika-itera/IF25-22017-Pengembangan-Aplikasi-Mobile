// Hands-on 2: Custom Exception & Exception Hierarchy
// Tugas: Buat exception kustom untuk kasus saldo tidak cukup pada rekening
// bank sederhana, lalu tangani exception tersebut secara spesifik.

// TODO 1: Buat class InsufficientBalanceException yang meng-extend Exception
//         dan menerima parameter message: String
// class InsufficientBalanceException(...) : ...

class BankAccount(private val owner: String, startBalance: Double) {
    var balance: Double = startBalance
        private set

    fun deposit(amount: Double) {
        require(amount > 0) { "Jumlah deposit harus lebih besar dari 0" }
        balance += amount
    }

    fun withdraw(amount: Double) {
        require(amount > 0) { "Jumlah penarikan harus lebih besar dari 0" }

        // TODO 2: Jika amount > balance, lempar InsufficientBalanceException
        //         dengan pesan yang menyebutkan nama pemilik, saldo, dan
        //         jumlah yang diminta.
        // TODO 3: Jika cukup, kurangi balance dengan amount.
    }
}

fun main() {
    val account = BankAccount("Andi", 100_000.0)

    account.deposit(50_000.0)
    println("Saldo setelah deposit: ${account.balance}")

    // TODO 4: Panggil account.withdraw(500_000.0) di dalam try-catch,
    //         tangkap InsufficientBalanceException secara spesifik dan
    //         cetak pesan errornya (JANGAN biarkan program crash).

    account.withdraw(30_000.0)
    println("Saldo akhir: ${account.balance}")
}
