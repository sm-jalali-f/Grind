package org.example

/**
 * 242. Valid Anagram
 * link: https://leetcode.com/problems/valid-anagram/description/
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word
 * or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 *       Input: s = "anagram", t = "nagaram"
 *       Output: true
 *
 * Example 2:
 *       Input: s = "rat", t = "car"
 *       Output: false
 *
 * Constraints:
 *      1 <= s.length, t.length <= 5 * 104
 *      s and t consist of lowercase English letters.
 *
 *
 *
 * */
class Q7ValidAnagram {
    /*best one*/
    fun isAnagram(s: String, t: String): Boolean {

        if (s.length != t.length) return false

        var freqS = IntArray(26)
        var freqT = IntArray(26)

        for (char in s.toCharArray()) {
            freqS[char - 'a']++
        }

        for (char in t.toCharArray()) {
            freqT[char - 'a']++
        }

        for (char in s.toCharArray()) {
            if (freqS[char - 'a'] != freqT[char - 'a'])
                return false
        }

        return true

    }

    fun mySolution(s: String, t: String): Boolean {
        val input = s.toMutableList()
        for (ch in t) {
            if (!input.remove(ch))
                return false
        }
        return input.size == 0
    }
    /*fun isAnagram(s: String, t: String): Boolean {
        val mutableMap = mutableMapOf<Char, Int>()
        var count = 0
        for (ch in s) {
            if (mutableMap.containsKey(ch)) {
                mutableMap[ch]?.let {
                    mutableMap[ch] = it + 1
                    count+=1
                }
            } else {
                mutableMap[ch] = 1
                count+=1
            }
        }
        for (ch in t) {
            if (mutableMap.containsKey(ch)) {
                mutableMap[ch]?.let {
                    if (it == 0)
                        return false
                    mutableMap[ch] = it - 1
                    count-=1
                }
            } else {
                return false
            }
        }
        return count==0
    }*/
}