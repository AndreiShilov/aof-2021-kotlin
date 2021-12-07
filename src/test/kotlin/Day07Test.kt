import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day07Test {


    @Test
    fun `Should return 37 for the sample input`() {
        // given
        val readInput = readInput("Day07_test")

        // when
        val result = Day07.part1(readInput)

        // then
        assertEquals(37, result)
    }

    @Test
    fun `Part2 should return 168 for the sample input`() {
        // given
        val readInput = readInput("Day07_test")

        // when
        val result = Day07.part2(readInput)

        // then
        assertEquals(168, result)
    }
}