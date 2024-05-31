package org.example

import org.w3c.dom.NodeList

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

    /**
     * My Solution:
     * Time: 156 ms
     * Memory: 35.10 MB
     * */
    public fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var pointer1: ListNode? = list1
        var pointer2: ListNode? = list2
        var resultHead: ListNode? = null
        var resultPointer: ListNode? = null
        while (pointer1 != null || pointer2 != null) {
            if (pointer1 == null) {
                if (resultPointer == null) {
                    resultHead = pointer2
                    resultPointer = pointer2
                } else {
                    resultPointer.next = pointer2
                    resultPointer = pointer2
                }
                pointer2 = pointer2?.next
            } else if (pointer2 == null) {
                if (resultPointer == null) {
                    resultHead = pointer1
                    resultPointer = pointer1
                } else {
                    resultPointer.next = pointer1
                    resultPointer = pointer1
                }
                pointer1 = pointer1.next
            } else {
                if (pointer1.`val` <= pointer2.`val`) {
                    if (resultPointer == null) {
                        resultHead = pointer1
                        resultPointer = pointer1
                    } else {
                        resultPointer.next = pointer1
                        resultPointer = pointer1
                    }
                    pointer1 = pointer1.next
                } else {
                    if (resultPointer == null) {
                        resultHead = pointer2
                        resultPointer = pointer2
                    } else {
                        resultPointer.next = pointer2
                        resultPointer = pointer2
                    }
                    pointer2 = pointer2.next
                }
            }
        }
        return resultHead

    }

    /** recursive Idea
    * Time: 132 ms*/
    fun goodSolution(list1: ListNode?, list2: ListNode?): ListNode? {
        val l1 = list1
        val l2 = list2
        if(l1 == null && l2 == null) {
            return null
        }
        if(l1 == null) {
            return l2
        }
        if(l2 == null) {
            return l1
        }
        if(l1.`val` < l2.`val`){
            l1.next = goodSolution(l1.next, l2)
            return l1
        } else{
            l2.next = goodSolution(l2.next, l1)
            return l2
        }
    }

    /**
    * Time: 128 ms*/
    fun bestSolution(arg1: ListNode?,arg2: ListNode?): ListNode? {
        var head:ListNode? = null
        var iterator:ListNode? = null
        var list1 = arg1
        var list2 = arg2
        if(list1 == null) return list2
        else if(list2 == null) return list1

        if(list1.`val` <= list2.`val`){
            head = list1
            list1 = list1.next
        } else{
            head = list2
            list2 = list2.next
        }

        iterator = head

        while(list1 != null && list2 != null){
            if(list1.`val` <= list2.`val`){
                iterator!!.next = list1
                list1 = list1?.next
                iterator = iterator!!.next
            } else{
                iterator!!.next = list2
                list2 = list2?.next
                iterator = iterator!!.next
            }
        }

        if(list1 == null){
            while(list2 != null){
                iterator!!.next = list2
                iterator = iterator.next
                list2 = list2?.next
            }
        }

        if(list2 == null){
            while(list1 != null){
                iterator!!.next = list1
                iterator = iterator.next
                list1 = list1?.next
            }
        }
        return head
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null

        override fun equals(otherAny: Any?): Boolean {
            if (otherAny == null)
                return false
            val other = otherAny as ListNode

            if (this.`val` != other?.`val`)
                return false
            if (this.next == null && other.next == null)
                return true
            return this.next?.equals(other.next) == true
        }
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

}