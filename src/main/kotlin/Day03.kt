fun main() {

    println(Day03.part1(readInput("Day03")))
    println(Day03.part2(readInput("Day03")))

}


class Day03 {
    companion object {
        fun part1(input: List<String>): Int {

            if (input.isEmpty()) {
                return 0
            }

            val foldInput = foldInput(input)
            val threshold = input.size / 2

            return getOmega(foldInput, threshold) * getEpsilon(foldInput, threshold)
        }

        fun part2(input: List<String>): Int {

            if (input.isEmpty()) {
                return 0
            }

            val o2: Int = getO2Level(input)
            val co2: Int = getCO2Level(input)

            return o2 * co2
        }

        private fun getGasLvl(
            input: List<String>,
            columnIndex: Int,
            filter: (current: Char, mostCommon: Char) -> Boolean
        ): Int {
            if (input.size == 1) {
                return input[0].toInt(2)
            }

            val mostCommon = getMostCommon(input, columnIndex)

            return getGasLvl(input.filter { filter(it[columnIndex], mostCommon) }, columnIndex + 1, filter)
        }

        private fun getMostCommon(input: List<String>, columnIndex: Int): Char {
            val fold = input.fold(0) { acc, s -> acc + s[columnIndex].digitToInt() }
            return if (fold >= input.size / 2.0) '1' else '0'
        }

        private fun getCO2Level(input: List<String>): Int {
            return getGasLvl(input, 0) { current, mostCommon -> current != mostCommon }
        }

        private fun getO2Level(input: List<String>): Int {
            return getGasLvl(input, 0) { current, mostCommon -> current == mostCommon }
        }


        private fun foldInput(input: List<String>): IntArray {
            return input.fold(IntArray(input[0].length)) { acc, s ->
                s.forEachIndexed { index, elem -> acc[index] += elem.digitToInt() }
                acc
            }
        }

        private fun getOmega(foldResult: IntArray, threshold: Int): Int {
            return foldResult.joinToString("") { if (it > threshold) "1" else "0" }.toInt(2)
        }

        private fun getEpsilon(foldResult: IntArray, threshold: Int): Int {
            return foldResult.joinToString("") { if (it < threshold) "1" else "0" }.toInt(2)
        }
    }
}