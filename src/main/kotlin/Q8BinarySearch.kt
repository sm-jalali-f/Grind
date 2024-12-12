package org.example

/**
 * 704. Binary Search
 * @link: https://leetcode.com/problems/binary-search/description/
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *      Input: nums = [-1,0,3,5,9,12], target = 9
 *      Output: 4
 *      Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 *      Input: nums = [-1,0,3,5,9,12], target = 2
 *      Output: -1
 *      Explanation: 2 does not exist in nums so return -1
 *
 * Constraints:
 *      1 <= nums.length <= 104
 *      -104 < nums[i], target < 104
 *      All the integers in nums are unique.
 *      nums is sorted in ascending order.
 * */
class Q8BinarySearch {

    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        var m: Int
        while (l <= r) {
            m = l + (r - l) / 2

            if (target == nums[m]) return m
            else if (target < nums[m]) r = m - 1
            else if (target > nums[m]) l = m + 1
        }
        return -1
    }

    fun mySolution(list: IntArray, target: Int): Int {
        var start = 0

        var end = list.size - 1
        var middle = (start + end) / 2
        while (end >= start) {
            if (list[middle] == target) {
                return middle
            } else {
                if (start == end && end == middle)
                    return -1
                if (list[middle] < target) {
                    start = middle + 1
                    middle = (start + end) / 2
                } else {
                    end = middle - 1
                    middle = (start+end)/2
                }
            }
        }
        return -1
    }
}