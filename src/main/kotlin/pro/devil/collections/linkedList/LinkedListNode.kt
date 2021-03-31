package pro.devil.collections.linkedList

data class LinkedListNode<T>(var value: T, var next: LinkedListNode<T>? = null, var prev: LinkedListNode<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}