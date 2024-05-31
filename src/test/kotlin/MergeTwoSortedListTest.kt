import org.example.MergeTwoSortedList
import org.example.MergeTwoSortedList.ListNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.w3c.dom.NodeList
import java.util.LinkedList

class MergeTwoSortedListTest {

    val merge = MergeTwoSortedList()

    @Test
    fun mergeTwoLists() {
        var head1 = createLinkedList(intArrayOf(1, 2, 4))
        var head2 = createLinkedList(intArrayOf(1, 3, 4))
        var result = createLinkedList(intArrayOf(1, 1, 2, 3, 4, 4))
        assertEquals(result, merge.mergeTwoLists(head1, head2))
        head1 = createLinkedList(intArrayOf())
        head2 = createLinkedList(intArrayOf())
        result = createLinkedList(intArrayOf())
        assertEquals(result, merge.mergeTwoLists(head1, head2))

    }

    private fun printLinkList(head: ListNode?) {
        print("Start  ")
        var pointer: ListNode? = head
        while (pointer != null) {
            print(pointer.`val`)
            pointer = pointer.next
        }
        print(" End")
        println("")
    }

    private fun createLinkedList(input: IntArray): ListNode? {
        var head: ListNode? = null
        if (input.isEmpty())
            return head
        head = ListNode(input[0])
        var pointer: ListNode? = head
        for (i in 1 until input.size) {
            pointer?.next = ListNode(input[i])
            pointer = pointer?.next
        }
        return head
    }
}