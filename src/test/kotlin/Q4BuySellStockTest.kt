import org.example.Q4BuySellStock
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Q4BuySellStockTest {

    var sample = Q4BuySellStock()

    @Test
    fun maxProfit() {
        assertEquals(5, sample.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        assertEquals(0, sample.maxProfit(intArrayOf(7,6,4,3,1)))
    }
}