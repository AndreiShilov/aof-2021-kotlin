import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day01KtTest {

    @Test
    fun shouldReturn0ForEmptyArray() {
        assertEquals(0, part1(listOf()))
    }

    @Test
    fun `Should return 7 for the sample data`() {
        //given
        val input = readInput("Day01_test")

        //when
        val part1 = part1(input)

        //then
        assertEquals(7, part1)
    }

    @Test
    fun `Should return 5 for windowed approach fo the sample data`() {
        //given
        val input = readInput("Day01_test")

        //when
        val part1 = part2(input)

        //then
        assertEquals(5, part1)
    }
}
