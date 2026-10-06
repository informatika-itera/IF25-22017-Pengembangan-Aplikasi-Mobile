import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

// Hands-on 3: Test Lifecycle & Setup dengan @BeforeEach
// Tugas: Lengkapi setUp() supaya setiap test mendapat TodoList yang BARU dan
// KOSONG (tidak saling memengaruhi satu sama lain), lalu lengkapi ketiga test.
//
// CATATAN: file ini SENGAJA membuat semua test gagal (merah) sampai kamu
// melengkapi seluruh TODO -- itu normal untuk latihan ini!

class TodoListTest {

    private lateinit var todoList: TodoList

    @BeforeEach
    fun setUp() {
        // TODO: inisialisasi todoList dengan TodoList() yang baru.
        // Method ini dijalankan ULANG sebelum SETIAP @Test, jadi setiap test
        // selalu mulai dari kondisi kosong yang sama.
    }

    @Test
    @DisplayName("TodoList baru harus kosong")
    fun testNewListIsEmpty() {
        // TODO: assertTrue(todoList.isEmpty())

        fail("TODO: lengkapi testNewListIsEmpty()")
    }

    @Test
    @DisplayName("Menambah item menaikkan ukuran list")
    fun testAddIncreasesSize() {
        // TODO 1 (Act): todoList.add("Belajar Kotlin")
        // TODO 2 (Assert): assertEquals(1, todoList.size())

        fail("TODO: lengkapi testAddIncreasesSize()")
    }

    @Test
    @DisplayName("Menghapus item mengembalikan true dan mengurangi ukuran")
    fun testRemoveExistingItem() {
        // TODO 1 (Arrange): todoList.add("Belajar Kotlin")
        // TODO 2 (Act): val removed = todoList.remove("Belajar Kotlin")
        // TODO 3 (Assert): assertTrue(removed) dan assertEquals(0, todoList.size())

        fail("TODO: lengkapi testRemoveExistingItem()")
    }
}
