package org.example

import java.util.EmptyStackException
import java.util.Stack

class ValidParentheses {
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0)
            return false
        val stack: ArrayDeque<Char> = ArrayDeque()
        for (ch in s) {
            if (stack.isNotEmpty()) {
                if (ch == ')' && stack.last() == '(')
                    stack.removeLast()
                else if (ch == ']' && stack.last() == '[')
                    stack.removeLast()
                else if (ch == '}' && stack.last() == '{')
                    stack.removeLast()
                else if (ch in listOf(')', ']', '}'))
                    return false
                else
                    stack.add(ch)
            } else {
                if (ch in listOf(')', ']', '}'))
                    return false
                stack.add(ch)
            }
        }
        return stack.isEmpty()
    }

    fun goodSolution(s: String): Boolean {
        val stack = Stack<Char>()

        try {
            s.forEach { c ->
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c)
                } else {
                    val top = stack.pop()
                    if (!top.matches(c)) return false
                }
            }
        } catch(_: EmptyStackException) {
            return false
        }

        return stack.isEmpty()
    }

    private fun Char.matches(other: Char): Boolean {
        return (this == '(' && other == ')') || (this == '{' && other == '}') || (this == '[' && other == ']')
    }
}