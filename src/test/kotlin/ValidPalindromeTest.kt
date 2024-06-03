import org.example.ValidPalindrome
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ValidPalindromeTest {
    var sample = ValidPalindrome()

    @Test
    fun mySolution() {
        assertEquals(true, sample.mySolution("aa"))
    }
}