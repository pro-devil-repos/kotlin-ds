package pro.devil.collections

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PDLinkedListTests {

    @Test
    fun create_list_success() {
        val list = PDLinkedList<Int>()

        assertTrue { list.isEmpty() }
    }

    @Test
    fun push_element_success() {
        val list = PDLinkedList<Int>()

        list.push(3).push(2)

        list.push(1)

        assertEquals(list.size, 3)
    }

    @Test
    fun get_element_success() {
        val list = PDLinkedList<Int>()

        list.push(3).push(2).push(1)

        assertEquals(list.at(0), 1)
    }

    @Test
    fun append_element_success() {
        val list = PDLinkedList<Int>()

        list.append(3).append(2)

        list.append(1)

        assertEquals(list.size, 3)
    }

    @Test
    fun insert_element_success() {
        val list = PDLinkedList<Int>()

        list.push(3).push(2).push(1)
        list.insert(4, 1)

        assertEquals(list.size, 4)
        assertEquals(list.at(2), 4)
    }

    @Test
    fun pop_element_success() {
        val list = PDLinkedList<Int>()

        list.push(3).push(2).push(1)
        assertEquals(list.size, 3)

        var r = list.pop()
        assertEquals(list.size, 2)
        assertEquals(r, 1)

        list.pop()
        list.pop()

        r = list.pop()
        assertTrue { list.isEmpty() }
        assertNull(r)
    }

    @Test
    fun removeLast_element_success() {
        val list = PDLinkedList<Int>()

        list.push(3).push(2).push(1)
        assertEquals(list.size, 3)

        var r = list.removeLast()
        assertEquals(list.size, 2)
        assertEquals(r, 3)

        list.removeLast()
        list.removeLast()

        r = list.removeLast()
        assertTrue { list.isEmpty() }
        assertNull(r)
    }

    @Test
    fun removeAfter_element_success() {
        val list = PDLinkedList<Int>()

        list.push(3).push(2).push(1)
        assertEquals(list.size, 3)

        var r = list.removeAfter(1)
        assertEquals(list.size, 2)
        assertEquals(r, 3)

        r = list.removeAfter(1)
        assertEquals(list.size, 2)
        assertNull(r)
    }

    @Test
    fun iterate_elements_success() {
        val list = PDLinkedList<Int>()

        list.push(3).push(2).push(1)
        assertEquals(list.size, 3)

        for ((counter, item) in list.withIndex()) {
            when (counter) {
                0 -> assertEquals(item, 1)
                1 -> assertEquals(item, 2)
                2 -> assertEquals(item, 3)
            }
        }
    }

    @Test
    fun contains_element_success() {
        val list = PDLinkedList<Int>()

        list.push(3).push(2).push(1)

        assertTrue { list.contains(3) }
        assertFalse { list.contains(4) }
    }

    @Test
    fun containsAll_elements_success() {
        val list = PDLinkedList<Int>()
        val listNeeded = listOf(1, 2)
        val listNeeded2 = listOf(1, 2, 5)

        list.push(3).push(2).push(1)

        assertTrue { list.containsAll(listNeeded) }
        assertFalse { list.containsAll(listNeeded2) }
    }

    @Test
    fun add_element_success() {
        val list = PDLinkedList<Int>()

        list.push(3).push(2).push(1)

        assertTrue { list.add(3) }
        assertEquals(list.size, 4)
    }

    @Test
    fun addAll_elements_success() {
        val list = PDLinkedList<Int>()

        list.push(3).push(2).push(1)

        assertTrue { list.addAll(listOf(2, 3)) }
        assertEquals(list.size, 5)
    }

    @Test
    fun clear_list_success() {
        val list = PDLinkedList<Int>()

        list.push(3).push(2).push(1)
        list.clear()
        assertTrue { list.isEmpty() }
    }

    @Test
    fun remove_element_success() {
        val list = PDLinkedList<Int>()

        list.push(3).push(2).push(3)

        assertEquals(list.size, 3)

        list.remove(3)

        assertEquals(list.size, 2)
        assertEquals(list.pop(), 2)
        assertEquals(list.pop(), 3)
    }

    @Test
    fun removeAll_elements_success() {
        val list = PDLinkedList<Int>()

        list.push(3).push(2).push(3)

        assertEquals(list.size, 3)

        list.removeAll(listOf(2, 3))

        assertEquals(list.size, 1)
        assertEquals(list.pop(), 3)
    }

    @Test
    fun retainAll_elements_success() {
        val list = PDLinkedList<Int>()

        list.addAll(listOf(3, 2, 3, 4, 5))

        assertEquals(list.size, 5)

        list.retainAll(listOf(2, 5))

        assertEquals(2, list.size)
        assertTrue { list.containsAll(listOf(2, 5)) }
    }
}