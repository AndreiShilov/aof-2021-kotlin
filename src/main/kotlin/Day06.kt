class Day06 {
    companion object {
        fun part1(input: List<String>, days: Int): Long {
            val initialState: MutableList<Int> = input[0].split(",").map { it.toInt() }.toMutableList()

            return initialState
                .groupBy { it }
                .entries
                .map { entry -> Pair(entry.key, entry.value.count()) }
                .sumOf { pair -> getChildren(pair.first, days) * pair.second } + initialState.size

        }

        private fun getChildren(initialDay: Int, days: Int): Long {
            val daysLeft = days - (initialDay + 1)

            if (daysLeft < 0) {
                return 0
            }

            val childrenCount: Long = daysLeft / 7 + 1L
            var totalAllDescendentsCount: Long = childrenCount

            for (i in 0 until childrenCount) {
                totalAllDescendentsCount += getChildren(8, (daysLeft - i * 7).toInt())
            }

            return totalAllDescendentsCount
        }
    }
}

fun main() {
    println(Day06.part1(readInput("Day06"), 256))
}