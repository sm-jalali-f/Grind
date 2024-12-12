package org.example.topInterview

import kotlin.math.min

class JumpGameII {
    fun jumpCount(nums: IntArray, lastIndex: Int): Int {
        if (lastIndex == 0)
            return 0
        var minJump = lastIndex
        for (i in lastIndex - 1 downTo 0) {
            if (nums[i] >= lastIndex - i) {
                minJump = min(jumpCount(nums, i) + 1, minJump)
            }
        }
        return minJump
    }

    fun dynamicJump(nums: IntArray): Int {
        val minJumpList = IntArray(nums.size) { nums.size }
        minJumpList[0] = 0
        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                if (nums[j] >= i - j)
                    minJumpList[i] = min(minJumpList[i], minJumpList[j] + 1)
            }
        }
        println(minJumpList.joinToString(","))
        return minJumpList[nums.size - 1]
    }


    fun jump(nums: IntArray): Int {
//        return jumpCount(nums, nums.size - 1)
        return dynamicJump(nums)
    }
}