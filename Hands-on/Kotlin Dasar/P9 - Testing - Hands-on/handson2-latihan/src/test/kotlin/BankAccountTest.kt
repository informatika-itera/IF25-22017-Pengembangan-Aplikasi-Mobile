import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// Hands-on 2: Testing Exception
// Tugas: Lengkapi test untuk BankAccount, termasuk kasus withdraw() yang
// melempar InsufficientFundsException saat saldo tidak cukup.
//
// Konsep baru: assertThrows<TipeException> { ... } -- dari org.junit.jupiter.api,
// digunakan untuk memverifikasi bahwa sebuah blok kode MELEMPAR exception tertentu.

class BankAccountTest {

    @Test
    @DisplayName("Deposit menambah saldo dengan benar")
    fun testDeposit() {
        // TODO 1 (Arrange): buat BankAccount dengan saldo awal 100.0
        // TODO 2 (Act): panggil deposit(50.0)
        // TODO 3 (Assert): assertEquals(150.0, account.balance)

        fail("TODO: lengkapi testDeposit()")
    }

    @Test
    @DisplayName("Withdraw mengurangi saldo saat saldo cukup")
    fun testWithdrawSufficientBalance() {
        // TODO: Arrange-Act-Assert untuk saldo awal 100.0, withdraw 40.0,
        // hasil akhir harus 60.0

        fail("TODO: lengkapi testWithdrawSufficientBalance()")
    }

    @Test
    @DisplayName("Withdraw melempar InsufficientFundsException saat saldo tidak cukup")
    fun testWithdrawInsufficientBalance() {
        // TODO 1 (Arrange): buat BankAccount dengan saldo awal 50.0
        // TODO 2 (Act + Assert): gunakan
        //   assertThrows<InsufficientFundsException> { account.withdraw(100.0) }
        // untuk memastikan exception yang tepat dilempar

        fail("TODO: lengkapi testWithdrawInsufficientBalance()")
    }
}
