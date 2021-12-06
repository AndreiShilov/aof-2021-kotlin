import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day4Test {

    class Part1 {
        @Test
        fun `Should return for sample Data`() {
            // given
            val readInput = readInput("Day04_test")

            // when
            val winnerScore = Day4.part1(readInput);

            // then
            assertEquals(4512, winnerScore)
        }
    }
}