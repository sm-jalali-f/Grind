import org.example.MergeTwoSortedList
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MergeTwoSortedListTest {

    @Test
    fun mergeTwoLists() {
        val head1 =  MergeTwoSortedList.ListNode(1)
        head1.next = MergeTwoSortedList.ListNode(2)
        val l1 = head1.next
        l1?.next = MergeTwoSortedList.ListNode(4)
        val head2 =  MergeTwoSortedList.ListNode(1)
        head2.next = MergeTwoSortedList.ListNode(3)
        val l2 = head2.next
        l2?.next = MergeTwoSortedList.ListNode(4)

    }
}