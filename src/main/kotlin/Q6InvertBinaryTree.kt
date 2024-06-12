package org.example

/**
 * 226. Invert Binary Tree
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example 1:
 *       Input: root = [4,2,7,1,3,6,9]
 *       Output: [4,7,2,9,6,3,1]
 *
 * Example 2:
 *      Input: root = [2,1,3]
 *      Output: [2,3,1]
 *
 * Example 3:
 *       Input: root = []
 *       Output: []
 *
 * Constraints:
 *      The number of nodes in the tree is in the range [0, 100].
 *       -100 <= Node.val <= 100*/
class Q6InvertBinaryTree {

    /** Best Solution
     * Time:107ms
     * memory close to 0*/
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val left = root.left
        val right = root.right
        root.left = invertTree(right)
        root.right = invertTree(left)
        return root
    }

    /**
     * used memory and is slow
     * Time: 145ms*/
    fun mySolution(root: TreeNode?): TreeNode? {
        return swapBranch(root)
    }

    fun swapBranch(treeNode: TreeNode?): TreeNode? {
        if (treeNode == null)
            return treeNode
        treeNode.left = treeNode.right.also { treeNode.right = treeNode.left }
        swapBranch(treeNode.left)
        swapBranch(treeNode.right)
        return treeNode

    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}