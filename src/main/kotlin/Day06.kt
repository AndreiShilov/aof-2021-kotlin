class Day06 {
    companion object {
        fun part1(input: List<String>, days: Int): Int {
            val initialState: MutableList<Int> = input[0].split(",").map { it.toInt() }.toMutableList()

            var fishToAddCounter = 0
            for (i in 1..days) {
                for (k in 0 until initialState.size) {
                    if (initialState[k] == 0) {
                        initialState[k] = 6
                        fishToAddCounter += 1
                    } else initialState[k] -= 1
                }
                initialState.addAll(IntArray(fishToAddCounter) { 8 }.toList())
                fishToAddCounter = 0
            }

            return initialState.size
        }
    }
}

fun main() {
    println(Day06.part1(readInput("Day06"), 80))
}