class Day09 {

    companion object {
        fun part1(readInput: List<String>): Int {
            val matrix = readInput.map { it.split("").filter { it != "" }.map { it.toInt() } }

            var result = 0
            for (x in matrix.indices) {
                for (y in matrix[x].indices) {
                    val holeValue = isHole(x, y, matrix)
                    if (holeValue > -1) result += (holeValue + 1)
                }
            }

            return result
        }

        private fun isHole(x: Int, y: Int, matrix: List<List<Int>>): Int {
            val maxIndexY = matrix.size - 1
            val maxIndexX = matrix[0].size - 1
            val value = matrix[x][y]

            if(value == 9){
                return -1
            }

            if (x - 1 >= 0 && value > matrix[x - 1][y]) {
                return -1
            }

            if (x + 1 <= maxIndexY && value > matrix[x + 1][y]) {
                return -1
            }

            if (y - 1 >= 0 && value > matrix[x][y - 1]) {
                return -1
            }

            if (y + 1 <= maxIndexX && value > matrix[x][y + 1]) {
                return -1
            }

            return value
        }
    }
}

fun main() {

    println(Day09.part1(readInput("Day09")))
}