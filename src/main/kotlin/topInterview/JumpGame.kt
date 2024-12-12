package org.example.topInterview

/**
 * 55. Jump Game
 * @link: https://leetcode.com/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150
 * You are given an integer array nums. You are initially positioned
 * at the array's first index, and each element in the array represents
 * your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 * --------------------------------------------------------------
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what.
 * Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 * ------------------------------------------------------------------
 * Constraints:
 *
 *     1 <= nums.length <= 104
 *     0 <= nums[i] <= 105
 *
 *
 * */
class JumpGame {
    fun canAccessLast(nums: IntArray, lastIndex: Int): Boolean {
        if (lastIndex==0)
            return true
        for (i in lastIndex - 1 downTo 0) {
            if (nums[i] >= lastIndex - i) {
                return canAccessLast(nums, i)
            }
        }
        return false
    }

    fun canJump(nums: IntArray): Boolean {
        return canAccessLast(nums, nums.size - 1)
    }
}