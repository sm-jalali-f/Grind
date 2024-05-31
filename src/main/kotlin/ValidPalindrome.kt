package org.example

import kotlin.math.ceil

class ValidPalindrome {
    fun mySolution(s: String): Boolean {
        val finalString = s.replace(Regex("[^a-zA-Z0-9]"), "").toLowerCase()
        return finalString.substring(0, (ceil(finalString.length / 2f) - 1).toInt()) == finalString.substring(
            (ceil(
                finalString.length / 2f
            )).toInt()
        ).reversed()
//        for (i in 0 until ceil(finalString.length / 2f).toInt()) {
//
//            if (finalString[i] != finalString[finalString.length - 1 - i])
//                return false
//        }
//        return true
    }
}