import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day10Test {


    @Test
    fun `Should return 26397 for the sample input`() {
        // given
        val input = readInput("Day10_test")

        // when
        val result = Day10.part1(input)

        // then
        assertEquals(26397, result)
    }

    @Test
    fun `Part 2 should return 288957 for the sample input`() {
        // given
        val input = readInput("Day10_test")

        // when
        val result = Day10.part2(input)

        // then
        assertEquals(288957, result)
    }


}
