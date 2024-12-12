package topInterview

import org.example.topInterview.JumpGameII
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class JumpGameIITest {

    val sample = JumpGameII()

    @Test
    fun jump() {
        assertEquals(2, sample.jump(intArrayOf(2, 3, 1, 1, 4)))
//        assertEquals(2, sample.jump(intArrayOf(2,3,0,1,4)))
    }
}