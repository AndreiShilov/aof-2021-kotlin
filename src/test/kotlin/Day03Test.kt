import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day03Test {

    class Part1 {
        @Test
        fun `Should return 0 for empty input`() {

            // when
            val part1 = Day03.part1(arrayListOf())

            // then
            assertEquals(0, part1)
        }

        @Test
        fun `Should return 198 for the sample data`() {
            // given
            val readInput = readInput("Day03_test")

            // when
            val part1 = Day03.part1(readInput)

            // then
            assertEquals(198, part1)
        }
    }

    class Part2 {
        @Test
        fun `Should return 0 for empty input`() {

            // when
            val part1 = Day03.part2(arrayListOf())

            // then
            assertEquals(0, part1)
        }

        @Test
        fun `Should return 230 for the sample data`() {
            // given
            val readInput = readInput("Day03_test")

            // when
            val part1 = Day03.part2(readInput)

            // then
            assertEquals(230, part1)
        }
    }
}