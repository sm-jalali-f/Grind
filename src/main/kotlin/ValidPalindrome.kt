package org.example

import kotlin.math.ceil

/**
 * phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
 * non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Example 1:
 *       Input: s = "A man, a plan, a canal: Panama"
 *       Output: true
 *       Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Example 2:
 *       Input: s = "race a car"
 *       Output: false
 *       Explanation: "raceacar" is not a palindrome.
 *
 * Example 3:
 *       Input: s = " "
 *       Output: true
 *       Explanation: s is an empty string "" after removing non-alphanumeric characters.
 *       Since an empty string reads the same forward and backward, it is a palindrome.
 *
 * Constraints:
 *       1 <= s.length <= 2 * 105
 *       s consists only of printable ASCII characters.
 * */
class ValidPalindrome {
    fun mySolution(s: String): Boolean {
        val finalString = s.replace(Regex("[^a-zA-Z0-9]"), "").toLowerCase()
        return finalString.substring(0, (finalString.length / 2)) == finalString.substring(
            (ceil(
                finalString.length / 2f
            )).toInt()
        ).reversed()
    }

    /** first Answer:
     * Time: 141ms */
    fun bestSolution(s: String): Boolean {
        var l = 0
        var r = s.length - 1

        while (l <= r) {
            if (s[l].isLetterOrDigit() && s[r].isLetterOrDigit()) {
                if (s[l].lowercaseChar() != s[r].lowercaseChar()) return false
                l++
                r--
            } else if (!s[l].isLetterOrDigit()) {
                l++
            } else if (!s[r].isLetterOrDigit()) {
                r--
            }
        }

        return true
    }

    /** second Answer: (recursive)
     * Time: 149ms*/
    fun isPalindrome(s: String): Boolean {
        return compareChar(s, 0, s.length -1)
    }

    fun compareChar(s: String, i: Int, j: Int): Boolean{
        if (i>=j) return true
        val charI = s[i].lowercaseChar()
        val charJ = s[j].lowercaseChar()
        if (!inRange(charI)) return compareChar(s, i + 1, j)
        if (!inRange(charJ)) return compareChar(s, i, j -1)

        if (charI != charJ) return false
        return compareChar(s, i+1, j-1)

    }

    fun inRange(char: Char): Boolean{
        return (char >= '0' && char <= '9') || (char >='a' && char <='z')
    }
}