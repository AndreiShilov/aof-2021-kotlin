val sizesSet = setOf(2, 3, 4, 7)
val segmentsToDigits = mapOf(
    setOf(0, 1, 2, 4, 5, 6) to 0,
    setOf(2, 5) to 1,
    setOf(0, 2, 3, 4, 6) to 2,
    setOf(0, 2, 3, 5, 6) to 3,
    setOf(1, 2, 3, 5) to 4,
    setOf(0, 1, 3, 5, 6) to 5,
    setOf(0, 1, 3, 4, 5, 6) to 6,
    setOf(0, 2, 5) to 7,
    setOf(0, 1, 2, 3, 4, 5, 6) to 8,
    setOf(0, 1, 2, 3, 5, 6) to 9
)

fun randomConfig(words: List<String>, expectedNumbers: List<String>): Int {
    val inputCables = 0..6
    val inputChars = 'a'..'g'
    fun buildMapping(): Map<Char, Int> {
        permute@ while (true) {
            val perm = inputChars.zip(inputCables.shuffled()).toMap()
            for (word in words) {
                val mapped = word.map { perm[it]!! }.toSet()
                val isValidDigit = segmentsToDigits.containsKey(mapped)
                if (!isValidDigit) continue@permute
            }
            return perm
        }
    }

    val mapping = buildMapping()
    val num = expectedNumbers.joinToString("") { digit ->
        val segments = digit.map { mapping[it]!! }.toSet()
        val dig = segmentsToDigits[segments]!!
        "$dig"
    }
    return num.toInt()
}


class Day08 {

    companion object {
        fun part1(readInput: List<String>): Int {
            return readInput
                .map { it.split(" | ")[1] }
                .map { it.split(" ").map { it.length } }
                .sumOf { it.map { size -> sizesSet.contains(size) }.count { it } }
        }

        fun part2(readInput: List<String>): Int {
            val lists = readInput
                .map { val (input, output) = it.split(" | "); input.split(" ") to output.split(" ") }
            return lists.sumOf { (input, output) ->
                randomConfig(input, output)
            }
        }

    }

}


fun main() {
    println(Day08.part1(readInput("Day08")))
    println(Day08.part2(readInput("Day08")))
}