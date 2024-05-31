import org.example.BuySellStock
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BuySellStockTest {

    var sample = BuySellStock()

    @Test
    fun maxProfit() {
        assertEquals(5, sample.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        assertEquals(0, sample.maxProfit(intArrayOf(7,6,4,3,1)))
    }
}