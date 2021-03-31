package pro.devil.collections_ex

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertDoesNotThrow
import pro.devil.collections_ex.linkedList.BiLinkedList
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BiLinkedListTests {

    @Test
    fun test_BiLInkedList_create_success() {
        assertDoesNotThrow {
            val list = BiLinkedList<Int>()

            assertTrue { list.isEmpty() }
            assertNull(list.first)
        }
    }

    @Test
    fun test_append_success() {
        val list = BiLinkedList<Int>()

        list.append(1)
        list.append(2)

        assertNotNull(list.first)
        assertEquals(1, list.first?.value)
    }

    @Test
    fun test_get_node_by_index() {
        val list = BiLinkedList<Int>()

        list.append(1)
        list.append(5)
        list.append(7)

        assertEquals(5, list.nodeAt(1)?.value)
    }

    @Test
    fun test_remove_success() {
        val list = BiLinkedList<Int>()

        list.append(1)
        list.append(5)
        list.append(7)

        val node = list.nodeAt(1)

        assertNotNull(node)
        assertEquals(5, list.remove(node))
        println(list)
        val node2 = list.nodeAt(1)
        assertNotNull(node2)
        assertEquals(7, node2.value)
    }
}