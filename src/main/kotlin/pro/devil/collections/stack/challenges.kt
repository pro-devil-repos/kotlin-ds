package pro.devil.collections.stack


fun main() {
    // Печатаем стек в обратном порядке без использования рекурсии
    val stack = stackOf<Int>(1, 2, 3, 4, 5)
    println(stack)
    val newStack = stackOf<Int>()

    while (!stack.isEmpty) {
        newStack.push(stack.pop()!!)
    }
    println(newStack)

    // Проверка четности скобок (открывающих и закрывающих)
    val inStrGood = "H((e))lo(world)()"
    val inStrBad = "(hello(world)"

    println(validateParentheses(inStrGood))
    println(validateParentheses(inStrBad))
}

fun validateParentheses(str: String): Boolean {
    val chStack = stackOf<Char>()
    for (ch in str) {
        when (ch) {
            '(' -> chStack.push(ch)
            ')' -> chStack.pop() ?: run {
                return false
            }
        }
    }

    return chStack.isEmpty
}

