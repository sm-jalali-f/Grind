import org.example.Q9FloodFill
import org.junit.jupiter.api.Test

class Q9FloodFillTest {

    var sample = Q9FloodFill()

    @Test
    fun floodFill() {
        var image = mutableListOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
        var result = mutableListOf(intArrayOf(2, 2, 2), intArrayOf(2, 2, 0), intArrayOf(2, 0, 1))
        println(result)
        println("---------------------")
        println(sample.floodFill(image.toTypedArray(), 1, 1, 2))
//        assertEquals(result, sample.floodFill(image, 1, 1, 2))

    }
}