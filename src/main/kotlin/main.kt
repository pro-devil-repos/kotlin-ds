import pro.devil.collections.linkedList.*

fun main() {
    val list = LinkedList<Int>()
    val list2 = LinkedList<Int>()

    list.append(1).append(2).append(3)
    list2.append(1).append(2).append(3).append(4)

    println(list.middleItem())
    println(list2.middleItem())

    list.printReversed()

    println(list)
    println(list.reversedList())


}