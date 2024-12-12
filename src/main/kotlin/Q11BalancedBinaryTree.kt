package org.example

import kotlin.math.abs
import kotlin.math.max
/**
 * Question 110. Balanced Binary Tree
 * @link: https://leetcode.com/problems/balanced-binary-tree/submissions/1285757125/
 * My Solution:     168ms recursive
 * BestSolution:    140ms
 * both algorithm are same but implementations are a little bit different.
 * */
class Q11BalancedBinaryTree {
    fun mySolution(root: TreeNode?): Boolean {
        return depth(root).second

    }

    fun depth(node: TreeNode?): Pair<Int, Boolean> {
        if (node == null)
            return Pair(0, true)
        val left = depth(node.left)
        val right = depth(node.right)
        return Pair(max(left.first, right.first) + 1, left.second && right.second && abs(left.first - right.first) <= 1)
    }


    fun isBalanced(root: TreeNode?): Boolean {
        return dfs(root).first
    }

    private fun dfs(root: TreeNode?): Pair<Boolean, Int> {
        if(root == null) return (true to 0)

        val left = dfs(root?.left)
        val right = dfs(root?.right)
        val isBalanced = left.first && right.first && abs(left.second - right.second) <= 1

        return (isBalanced to 1 + maxOf(left.second, right.second))
    }
}