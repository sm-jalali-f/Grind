import org.example.InvertBinaryTree
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class InvertBinaryTreeTest {

    var sample = InvertBinaryTree()

    @Test
    fun invertTree() {
        var input = intArrayOf(4, 2, 7, 1, 3, 6, 9)
        var expected = intArrayOf(4, 7, 2, 9, 6, 3, 1)
        assertEquals(expected, sample.invertTree(input))

        input = intArrayOf(2, 1, 3)
        expected = intArrayOf(2, 3, 11)
        assertEquals(expected, sample.invertTree(input))

    }
}