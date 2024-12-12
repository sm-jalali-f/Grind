import org.example.Q8BinarySearch
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Q8BinarySearchTest {

    val sample = Q8BinarySearch()
    @Test
    fun search() {
        assertEquals(4,sample.search(intArrayOf(-1,0,3,5,9,12), target = 9))
        assertEquals(-1,sample.search(intArrayOf(-1,0,3,5,9,12), target = 2))
        assertEquals(0,sample.search(intArrayOf(2,5), target = 2))
        assertEquals(1,sample.search(intArrayOf(2,5), target = 5))
        assertEquals(0,sample.search(intArrayOf(-1,0,5), target = -1))
//        assertEquals(4,sample.search(intArrayOf(-1,0,3,5,9,12), target = 9))
    }
}