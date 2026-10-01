class InsufficientFundsException(message: String) : Exception(message)

class BankAccount(initialBalance: Double) {
    var balance: Double = initialBalance
        private set

    fun deposit(amount: Double) {
        require(amount > 0) { "Jumlah setor harus positif" }
        balance += amount
    }

    fun withdraw(amount: Double) {
        require(amount > 0) { "Jumlah tarik harus positif" }
        if (amount > balance) {
            throw InsufficientFundsException("Saldo tidak cukup: saldo=$balance, diminta=$amount")
        }
        balance -= amount
    }
}
