package pro.devil.collections.linkedList


class BiLinkedList<T> {
    private var head: LinkedListNode<T>? = null
    private var tail: LinkedListNode<T>? = null

    val first: LinkedListNode<T>?
        get() = head

    fun isEmpty() = head == null

    fun append(value: T) {
        val newNode = LinkedListNode<T>(value, prev = tail)

        if (isEmpty()) {
            head = newNode
            tail = newNode
            return
        }

        tail?.next = newNode

        tail = newNode
    }

    fun nodeAt(index: Int): LinkedListNode<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex += 1
        }

        return currentNode
    }

    fun remove(node: LinkedListNode<T>): T {
        val prev = node.prev
        val next = node.next

        if (prev != null) {
            prev.next = next
        } else {
            head = next
        }

        next?.prev = prev

        if (next == null) {
            tail = prev
        }

        node.prev = null
        node.next = null

        return node.value
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }
}