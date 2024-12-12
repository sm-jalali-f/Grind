import org.example.Q10LowestCommonAncestor
import org.example.TreeNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Q10LowestCommonAncestorTest {

    var sample = Q10LowestCommonAncestor()

    @Test
    fun lowestCommonAncestor() {
        val root = TreeNode(6)
        root.left = TreeNode(2)
        root.right = TreeNode(8)
        root.left?.left = TreeNode(0)
        root.left?.right = TreeNode(4)
        root.left?.right?.left = TreeNode(3)
        root.left?.right?.right = TreeNode(5)
        root.right?.left = TreeNode(7)
        root.right?.right = TreeNode(9)
        assertEquals(4, sample.lowestCommonAncestor(root, root.left?.right, root.left?.right?.right)?.`val`)
        assertEquals(4, sample.lowestCommonAncestor(root, root.left?.right?.left, root.left?.right?.right)?.`val`)
        assertEquals(6, sample.lowestCommonAncestor(root, root.left?.right?.left, root.right)?.`val`)
        assertEquals(2, sample.lowestCommonAncestor(root, root.left?.left, root.left)?.`val`)
        assertEquals(4, sample.lowestCommonAncestor(root, root.left?.right?.left, root.left?.right?.right)?.`val`)
    }
}