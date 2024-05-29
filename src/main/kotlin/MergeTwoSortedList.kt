package org.example

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class MergeTwoSortedList {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var pointer1: ListNode? = list1
        var pointer2: ListNode? = list2
        var result: ListNode? = null
        while (pointer1 != null || pointer2 != null) {
            if (pointer1 == null && pointer2 != null) {
                if (result == null)
                    result = pointer2
                else
                    result.next = pointer2
                pointer2 = pointer2.next
            } else if (pointer1 != null && pointer2 == null) {
                if (result == null)
                    result = pointer1
                else
                    result.next = pointer1
                pointer1 = pointer1.next
            } else if (pointer1?.`val`!! <= pointer2?.`val`!!) {
                if (result == null)
                    result = pointer1
                else
                    result.next = pointer1
                pointer1 = pointer1.next
            } else {
                if (result == null)
                    result = pointer2
                else
                    result.next = pointer2
                pointer2 = pointer2.next
            }
        }
        return result

    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}