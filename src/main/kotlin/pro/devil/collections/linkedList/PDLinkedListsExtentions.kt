package pro.devil.collections.linkedList

fun <T> PDLinkedListNode<T>.printReversed() {
    this.next?.printReversed()

    if (this.next != null) {
        print(" -> ")
    }

    print(this.value.toString())
}

fun <T> PDLinkedList<T>.printReversed() {
    this.nodeAt(0)?.printReversed()
    println()
}


fun <T> PDLinkedList<T>.middleItem() = this.at(this.size / 2)

private fun <T> addInReverse(list: PDLinkedList<T>, node: PDLinkedListNode<T>) {
    val next = node.next

    if (next != null) {
        addInReverse(list, next)
    }

    list.append(node.value)
}

fun <T> PDLinkedList<T>.reversedList(): PDLinkedList<T> {
    val result = PDLinkedList<T>()
    val head = nodeAt(0)

    if (head != null) {
        addInReverse(result, head)
    }

    return result
}