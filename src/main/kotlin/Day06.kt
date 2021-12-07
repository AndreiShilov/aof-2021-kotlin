class Day06 {
    companion object {
        fun part1(input: List<String>, days: Int): Int {
            val initialState: MutableList<Int> = input[0].split(",").map { it.toInt() }.toMutableList()

            var fishToAddCounter = 0
            var fishTotalCounter = 0
            for (k in 0 until initialState.size) {
                val initialStateSingle = mutableListOf(initialState[k])
                for (i in 1..days) {
                    for (j in 0 until initialStateSingle.size) if (initialStateSingle[j] == 0) {
                        initialStateSingle[j] = 6
                        fishToAddCounter += 1
                    } else initialStateSingle[j] -= 1
                    initialStateSingle.addAll(IntArray(fishToAddCounter) { 8 }.toList())
                    fishToAddCounter = 0
                    println(initialStateSingle.size)
                }
                fishTotalCounter += initialStateSingle.size
            }

            return fishTotalCounter
        }
    }
}

fun main() {
    println(Day06.part1(readInput("Day06"), 80))
}