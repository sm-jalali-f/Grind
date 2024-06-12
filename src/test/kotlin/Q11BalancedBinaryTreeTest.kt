import org.example.Q11BalancedBinaryTree
import org.example.TreeNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Q11BalancedBinaryTreeTest {

    val sample = Q11BalancedBinaryTree()

    @Test
    fun isBalanced() {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right?.left = TreeNode(15)
        root.right?.right = TreeNode(7)
        assertEquals(true, sample.isBalanced(root))
        val root2 = TreeNode(3)
        root2.left = TreeNode(9)
        root2.right = TreeNode(20)
        root2.right?.left = TreeNode(15)
        root2.right?.right = TreeNode(7)
        root2.right?.left?.left = TreeNode(8)
        assertEquals(false, sample.isBalanced(root2))
    }
}