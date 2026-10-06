class TodoList {
    private val items = mutableListOf<String>()

    fun add(item: String) {
        items.add(item)
    }

    fun remove(item: String): Boolean = items.remove(item)

    fun size(): Int = items.size

    fun isEmpty(): Boolean = items.isEmpty()
}
