class Calculator {
    fun add(a: Int, b: Int): Int = a + b

    fun subtract(a: Int, b: Int): Int = a - b

    fun divide(a: Int, b: Int): Int {
        require(b != 0) { "Pembagi tidak boleh nol" }
        return a / b
    }
}
