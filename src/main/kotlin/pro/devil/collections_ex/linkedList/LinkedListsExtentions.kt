package pro.devil.collections_ex.linkedList

fun <T> LinkedListNode<T>.printReversed() {
    this.next?.printReversed()

    if (this.next != null) {
        print(" -> ")
    }

    print(this.value.toString())
}

fun <T> LinkedList<T>.printReversed() {
    this.nodeAt(0)?.printReversed()
    println()
}


fun <T> LinkedList<T>.middleItem() = this.at(this.size / 2)

private fun <T> addInReverse(list: LinkedList<T>, node: LinkedListNode<T>) {
    val next = node.next

    if (next != null) {
        addInReverse(list, next)
    }

    list.append(node.value)
}

fun <T> LinkedList<T>.reversedList(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = nodeAt(0)

    if (head != null) {
        addInReverse(result, head)
    }

    return result
}