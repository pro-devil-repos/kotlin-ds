package pro.devil.collections

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertDoesNotThrow
import pro.devil.collections.stack.PDStack
import pro.devil.collections.stack.stackOf
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StackTests {
    @Test
    fun create_stack_success_test() {
        assertDoesNotThrow {
            // Просто создаем пустой стек
            val s1 = PDStack<Int>()
            assertTrue { s1.isEmpty }

            // Разные варианты стеков
            val s2 = PDStack(listOf(1, 2, 3))
            assertEquals(3, s2.count)

            val s3 = stackOf(3, 5, 3, 6, 7)
            assertEquals(5, s3.count)
        }
    }

    @Test
    fun stack_push_pop_success_test() {
        val stack = PDStack<Int>()

        stack.push(3)
        stack.push(1)
        stack.push(2)

        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())
        assertEquals(3, stack.pop())
        assertNull(stack.pop())
    }

    @Test
    fun stack_count_test() {
        val stack = PDStack<Int>()

        stack.push(3)
        stack.push(1)
        stack.push(2)

        assertEquals(3, stack.count)
    }

    @Test
    fun stack_is_empty_test() {
        val stack = PDStack<Int>()
        assertTrue { stack.isEmpty }
        stack.push(3)
        assertFalse { stack.isEmpty }
    }

    @Test
    fun stack_peek_test() {
        val stack = PDStack<Int>()

        stack.push(3)
        stack.push(1)
        stack.push(2)

        assertEquals(2, stack.peek())
        // Кол-во элементов не должно измениться (этим отличается от pop() )
        assertEquals(3, stack.count)
    }
}