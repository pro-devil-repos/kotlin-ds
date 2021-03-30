import pro.devil.collections.linkedList.*

fun main() {
    val list = PDLinkedList<Int>()
    val list2 = PDLinkedList<Int>()

    list.append(1).append(2).append(3)
    list2.append(1).append(2).append(3).append(4)

    println(list.middleItem())
    println(list2.middleItem())

    list.printReversed()

    println(list)
    println(list.reversedList())


}