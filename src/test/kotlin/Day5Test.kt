import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day5Test {


    @Test
    fun part1Test() {
        // given
        val readInput = readInput("Day05_test")
        // when
        val result = Day5.part1(readInput);

        // then
        assertEquals(5, result)

    }

    @Test
    fun part2Test() {
        // given
        val readInput = readInput("Day05_test")
        // when
        val result = Day5.part2(readInput);
        // then
        assertEquals(12, result)

    }

}