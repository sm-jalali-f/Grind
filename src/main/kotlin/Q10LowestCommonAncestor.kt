package org.example

import kotlin.math.max
import kotlin.math.min

/**
 * 235. Lowest Common Ancestor (LCA) of a binary search tree
 * @link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * my Solution:      236 ms , 40.5 MB
 * best Solution:    191 ms
 * */

class Q10LowestCommonAncestor {
    /* best solution*/
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var rootIter = root
        val minimum = min(p!!.`val`, q!!.`val`)
        val maximum = max(p.`val`, q.`val`)

        while (rootIter != null) {
            if (rootIter.`val` < minimum) {
                rootIter = rootIter.right
            }
            if (rootIter!!.`val` > maximum) {
                rootIter = rootIter.left
            }
            if (rootIter!!.`val` >= minimum && rootIter.`val` <= maximum) {
                return rootIter
            }
        }
        return null
    }

    fun mySolution(root: TreeNode, p: TreeNode?, q: TreeNode?): TreeNode? {
        val maximum = q?.let { p?.let { it1 -> max(it1.`val`, it.`val`) } }
        val minimum = q?.let { p?.let { it1 -> min(it1.`val`, it.`val`) } }
        return dfs(root, minimum, maximum)
    }

    private fun dfs(root: TreeNode?, minimum: Int?, maximum: Int?): TreeNode? {
        if (root == null || minimum == null || maximum == null)
            return null
        return if (root.`val` <= maximum && root.`val` >= minimum) {
            root
        } else if (root.`val` < maximum && root.`val` < minimum) {
            dfs(root.right, minimum, maximum) ?: root
        } else if (root.`val` > maximum && root.`val` > minimum) {
            dfs(root.left, minimum, maximum) ?: root
        } else {
            root
        }
    }


}