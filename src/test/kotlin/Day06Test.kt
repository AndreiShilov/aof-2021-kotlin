import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day06Test {


    @Test
    fun `Should return 26 for 18 days`() {
        // given
        val readInput = readInput("Day06_test")

        // when
        val result = Day06.part1(readInput,18)

        // then
        assertEquals(26, result)
    }

    @Test
    fun `Should return 5934 for 80 days`() {
        // given
        val readInput = readInput("Day06_test")

        // when
        val result = Day06.part1(readInput,80)

        // then
        assertEquals(5934, result)
    }

    @Test
    fun `Should return 26984457539 for 256 days`() {
        // given
        val readInput = readInput("Day06_test")

        // when
        val result = Day06.part1(readInput,256)

        // then
        assertEquals(26984457539, result)
    }
}