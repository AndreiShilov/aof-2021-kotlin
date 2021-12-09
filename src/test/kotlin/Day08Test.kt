import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day08Test {

    @Test
    fun `Should return 26 for sample data`() {
        // given
        val readInput = readInput("Day08_test")

        // when
        val result = Day08.part1(readInput)

        // then
        assertEquals(26, result)
    }


    @Test
    fun `Part 2 should return 61229 for sample data`() {
        // given
        val readInput = readInput("Day08_test")

        // when
        val result = Day08.part2(readInput)

        // then
        assertEquals(61229, result)
    }

}