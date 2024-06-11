package org.example

/**
 * 733. Flood Fill
 * @link: https://leetcode.com/problems/flood-fill/description/
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 * Return the modified image after performing the flood fill.
 *
 * Example 1:
 *      Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 *      Output: [[2,2,2],[2,2,0],[2,0,1]]
 *      Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 *      Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 * Example 2:
 *      Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
 *      Output: [[0,0,0],[0,0,0]]
 *      Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 *
 *  Constraints:
 *       m == image.length
 *       n == image[i].length
 *       1 <= m, n <= 50
 *       0 <= image[i][j], color < 216
 *       0 <= sr < m
 *       0 <= sc < n
 * */
class FloodFill {
    /**
     * time: 245ms
     * memory: 37.86 MB*/
    fun mySolution(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val neighbourCheck: MutableSet<Pair<Int, Int>> = mutableSetOf()
        val changedNeighbour: MutableMap<Pair<Int, Int>, Boolean> = mutableMapOf()

        neighbourCheck.add(Pair(sr, sc))
        do {
            val pair = neighbourCheck.elementAt(0)
            val row = pair.first
            val col = pair.second
            if (row > 0 && image[row - 1][col] == image[sr][sc]) {
                if (!changedNeighbour.contains(Pair(row - 1, col)))
                    neighbourCheck.add(Pair(row - 1, col))
            }
            if (col > 0 && image[row][col - 1] == image[sr][sc]) {
                if (!changedNeighbour.contains(Pair(row, col - 1)))
                    neighbourCheck.add(Pair(row, col - 1))
            }
            if (row < image.size - 1 && image[row + 1][col] == image[sr][sc]) {
                if (!changedNeighbour.contains(Pair(row + 1, col)))
                    neighbourCheck.add(Pair(row + 1, col))
            }
            if (col < image[0].size - 1 && image[row][col + 1] == image[sr][sc]) {
                if (!changedNeighbour.contains(Pair(row, col + 1)))
                    neighbourCheck.add(Pair(row, col + 1))
            }
            neighbourCheck.remove(Pair(row, col))
            changedNeighbour[Pair(row, col)] = true
        } while (neighbourCheck.isNotEmpty())

        val result = image.clone()
        changedNeighbour.keys.forEach { item -> result[item.first][item.second] = color }
        return result
    }

    /**
     * time: 203ms */
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val m = image.size
        val n = image[m - 1].size
        val visited = Array<BooleanArray>(m) { BooleanArray(n) }
        fill(sr, sc, image[sr][sc], color, image, visited, m, n)
        return image
    }

    private fun fill(i: Int, j: Int, target: Int, color: Int, image: Array<IntArray>, visited: Array<BooleanArray>, m: Int, n: Int) {
        if (i < 0 || j < 0 || i >= m || j >= n || image[i][j] != target || visited[i][j]) return
        image[i][j] = color
        visited[i][j] = true
        fill(i - 1, j, target, color, image, visited, m, n)
        fill(i, j - 1, target, color, image, visited, m, n)
        fill(i + 1, j, target, color, image, visited, m, n)
        fill(i, j + 1, target, color, image, visited, m, n)
    }
}