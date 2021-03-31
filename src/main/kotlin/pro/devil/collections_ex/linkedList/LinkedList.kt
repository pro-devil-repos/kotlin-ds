package pro.devil.collections_ex.linkedList

/**
 * Тестовая реализация связного списка
 */
class LinkedList<T> : Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T> {
    private var head: LinkedListNode<T>? = null
    private var tail: LinkedListNode<T>? = null
    override var size: Int = 0
        private set

    /**
     * Проверка на заполненность
     */
    override fun isEmpty() = size == 0

    /**
     * Добавление элемента в начало списка
     */
    fun push(value: T): LinkedList<T> {
        head = LinkedListNode(value = value, next = head)

        if (tail == null) {
            tail = head
        }

        size++

        return this
    }

    /**
     * Добавление элемента в конец списка
     */
    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            push(value)
        } else {
            tail?.next = LinkedListNode(value)
            tail = tail?.next

            size++
        }

        return this
    }

    /**
     * Добавление элемента в середину списка
     */
    fun insert(value: T, afterIndex: Int): LinkedList<T> {
        val afterNode = nodeAt(afterIndex)

        if (tail == afterNode) {
            append(value)
        } else if (afterNode != null) {
            val newNode = LinkedListNode(value, afterNode.next)
            afterNode.next = newNode
            size++
        }

        return this
    }

    /**
     * Получение элемента по индексу
     */
    fun at(index: Int): T? = nodeAt(index)?.value

    /**
     * Извлекаем элемент с начала списка (с удалением)
     */
    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value

        head = head?.next

        if (isEmpty()) tail = null

        return result
    }

    /**
     * Извлекаем элемент с конца списка (с удалением)
     */
    fun removeLast(): T? {
        // Если пустой список то нуль
        val head = head ?: return null
        // Если один элемент то попаем его
        if (head.next == null) return pop()
        size--

        var prev = head
        var current = head

        // Ищем элемент у которого нет следующего элемента
        // не можем использовать тейл, потому что список однонаправленный и мы не знаем предыдущих
        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev

        return current.value
    }

    /**
     * Извлекаем произвольный элемент из списка (с удалением)
     */
    fun removeAfter(index: Int): T? {
        val node = nodeAt(index) ?: return null

        val result = node.next?.value

        // Если следующий элемент это "хвост" - сдвигаем хвост
        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }

        node.next = node.next?.next

        return result
    }

    fun nodeAt(index: Int): LinkedListNode<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator<T>(this)
    }

    /**
     * Collection Interface
     */

    /**
     *  Содержит ли искомый элемент?
     */
    override fun contains(element: T) = this.any { it == element }

    /**
     * Содержит ли все искомые элементы?
     */
    override fun containsAll(elements: Collection<T>) = elements.all { this.contains(it) }

    /**
     * MutableCollection Interface
     */

    /**
     * Добавление элемента в конец списка
     */
    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    /**
     * Добавление группы элементов в конец списка
     */
    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            append(element)
        }

        return true
    }

    /**
     * Очищаем список
     */
    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    /**
     * Удаление элемента из списка (первого найденого)
     */
    override fun remove(element: T): Boolean {
        val iterator = iterator()

        while (iterator.hasNext()) {
            val item = iterator.next()

            if (item == element) {
                iterator.remove()
                return true
            }
        }

        return false
    }

    /**
     * Удаление элементов из списка (каждый удаляется один раз, если будут дубли - останутся)
     */
    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements) {
            result = remove(item) || result
        }

        return result
    }

    /**
     * Удаление всех элементов из списка кроме указанных
     */
    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = iterator()

        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }

        return result
    }
}

