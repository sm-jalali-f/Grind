package org.example

import com.sun.source.tree.Tree
import kotlin.math.max
import kotlin.math.min

class LowestCommonAncestor {
    fun lowestCommonAncestor(root: TreeNode, p: TreeNode?, q: TreeNode?): TreeNode? {
        var maximum = q?.let { p?.let { it1 -> max(it1.`val`, it.`val`) } }
        var minimum = q?.let { p?.let { it1 -> min(it1.`val`, it.`val`) } }
        return dfs(root, minimum, maximum)
    }

    private fun dfs(root: TreeNode?, minimum: Int?, maximum: Int?): TreeNode? {
        if (root == null || minimum == null || maximum == null)
            return null
        var left: TreeNode? = null
        var right: TreeNode? = null
        if (root.`val` <= maximum && root.`val` >= minimum) {
            return root

        } else if (root.`val` < maximum && root.`val` < minimum) {
            right = dfs(root.right, minimum, maximum)
        } else if (root.`val` > maximum && root.`val` > maximum) {
            left = dfs(root.right, minimum, maximum)
        }
        var resultNode: TreeNode = root
        left?.let {
            if (left.`val` < root.`val`)
                resultNode = left
        }
        right?.let {
            if (right.`val` < resultNode.`val`)
                resultNode = right
        }

        return resultNode
    }


    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}