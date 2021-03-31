package pro.devil.collections.linkedList

import java.lang.IndexOutOfBoundsException

class LinkedListIterator<T>(private val list: LinkedList<T>) : Iterator<T>, MutableIterator<T> {
    private var index = 0
    private var lastNode: LinkedListNode<T>? = null

    override fun hasNext() = index < list.size

    override fun next(): T {
        if (index >= list.size) {
            throw IndexOutOfBoundsException()
        }

        lastNode = if (index == 0) {
            list.nodeAt(0)
        } else {
            lastNode?.next
        }

        index++

        return lastNode!!.value
    }

    override fun remove() {
        if (index == 1) {
            list.pop()
        } else {
            val cIndex = index - 2
            val prevNode = list.nodeAt(cIndex) ?: return
            list.removeAfter(cIndex)
            lastNode = prevNode
        }
        index--
    }
}