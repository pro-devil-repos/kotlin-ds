package pro.devil.collections.stack

interface Stack<E> {
    val count: Int

    val isEmpty: Boolean
        get() = count == 0

    fun push(element: E)
    fun pop(): E?
    fun peek(): E?
}

class PDStack<T>() : Stack<T> {
    private val storage = arrayListOf<T>()

    companion object {
        fun <E> create(items: Iterable<E>) = PDStack<E>(items)
    }

    constructor(items: Iterable<T>) : this() {
        items.forEach {
            this.push(it)
        }
    }

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (isEmpty) {
            return null
        }

        return storage.removeAt(count - 1)
    }

    override fun toString(): String {
        var result = ""

        storage.asReversed().forEach {
            result += "$it\n"
        }

        return result
    }

    override val count: Int
        get() = storage.size

    override fun peek() = storage.lastOrNull()
}

fun <T> stackOf(vararg elements: T) = PDStack<T>(elements.asList())