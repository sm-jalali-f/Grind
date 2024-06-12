import org.example.Q5ValidPalindrome
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Q5ValidPalindromeTest {
    var sample = Q5ValidPalindrome()

    @Test
    fun mySolution() {
        assertEquals(true, sample.mySolution("aa"))
    }
}