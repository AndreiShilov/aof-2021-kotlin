import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day09Test {

    @Test
    fun `Should return 15 for the sample data`() {
        // given
        val readInput = readInput("Day09_test")

        // when
        val result = Day09.part1(readInput)

        // then
        assertEquals(15, result)
    }
}