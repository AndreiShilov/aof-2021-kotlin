import kotlin.math.abs

class Day5 {


    companion object {
        fun part1(list: List<String>, filter: (Pair<Pair<Int, Int>, Pair<Int, Int>>) -> Boolean): Int {
            return list.map { parseInputLineToPairOfCoordinates(it) }
                .filter { vector -> filter(vector) }
                .flatMap { vector ->
                    val first = vector.first
                    val second = vector.second

                    val mutableListOf = mutableListOf(first, second)

                    val x = second.first - first.first
                    val y = second.second - first.second
                    val incrementX = if (x == 0) x else x / abs(x)
                    val incrementY = if (y == 0) y else y / abs(y)

                    var incrementedX = first.first + incrementX
                    var incrementedY = first.second + incrementY
                    while (incrementedX * incrementX + incrementedY * incrementY != second.first * incrementX + second.second * incrementY) {
                        mutableListOf.add(Pair(incrementedX, incrementedY))
                        incrementedX += incrementX
                        incrementedY += incrementY
                    }

                    mutableListOf
                }.fold(mutableMapOf<Pair<Int, Int>, Int>()) { map, pair ->
                    if (map.contains(pair)) map[pair] = map[pair]?.plus(1)!!
                    else map[pair] = 1
                    map
                }.count { entry -> entry.value >= 2 }
        }

        private fun parseInputLineToPairOfCoordinates(line: String): Pair<Pair<Int, Int>, Pair<Int, Int>> {

            val pairs = line.split(" -> ")
                .map { it.split(",") }
                .map { Pair(it[0].toInt(), it[1].toInt()) }

            return Pair(pairs[0], pairs[1])
        }
    }
}

fun main() {
    val part1 = Day5.part1(readInput("Day05"), filterPart1)
    val part2 = Day5.part1(readInput("Day05"), filterPart2)

    println(part1)
    println(part2)
}

val filterPart2 = { vector: Pair<Pair<Int, Int>, Pair<Int, Int>> ->
    vector.first.first == vector.second.first
            || vector.first.second == vector.second.second
            || abs(vector.first.first - vector.second.first) == abs(vector.first.second - vector.second.second)
}
val filterPart1 = { vector: Pair<Pair<Int, Int>, Pair<Int, Int>> ->
    vector.first.first == vector.second.first
            || vector.first.second == vector.second.second
}