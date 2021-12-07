import kotlin.math.abs

class Day07 {
    companion object {
        fun part1(readInput: List<String>): Int {
            val positions = readInput[0].split(",").map { it.toInt() }.sorted()

            val cheapestPosition = positions[positions.size / 2]
            return positions.sumOf { abs(cheapestPosition - it) }
        }

        fun part2(readInput: List<String>): Int {
            val positions = readInput[0].split(",").map { it.toInt() }.sorted()

            return (positions.first()..positions.last()).minOfOrNull { target ->
                positions.sumOf { crab ->
                    val second = abs(target - crab)
                    val i = second * (second + 1) / 2
                    i
                }
            } ?: error("")
        }
    }
}

fun main() {
    val readInput = readInput("Day07")
    println(Day07.part1(readInput))
    println(Day07.part2(readInput))
}