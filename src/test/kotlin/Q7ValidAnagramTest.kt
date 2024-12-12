import org.example.Q7ValidAnagram
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Q7ValidAnagramTest {

    val sample = Q7ValidAnagram()
    @Test
    fun isAnagram() {
        assertEquals(true,sample.isAnagram("anagram","nagaram"))
//        assertEquals(false,sample.isAnagram("asdasd","das1"))
//        assertEquals(false,sample.isAnagram("asdasd","yt"))
//        assertEquals(true,sample.isAnagram("asdasd","asd"))
    }
}