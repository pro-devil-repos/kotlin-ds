package pro.devil.collections

data class PDLinkedListNode<T>(var value: T, var next: PDLinkedListNode<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}