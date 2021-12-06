import kotlin.math.abs

class Day5 {


    companion object {
        fun part1(list: List<String>): Int {

            return list.map { parseInputLineToPairOfCoordinates(it) }
                .filter { vector ->
                    vector.first.first == vector.second.first || vector.first.second == vector.second.second
                }
                .flatMap { vector ->
                    val first = vector.first
                    val second = vector.second

                    val mutableListOf = mutableListOf<Pair<Int, Int>>()
                    if (first.first == second.first) {
                        val i = first.second - second.second

                        if (i < 0) for (k in first.second..second.second) {
                            mutableListOf.add(Pair(first.first, k))
                        }
                        else for (k in first.second downTo second.second) {
                            mutableListOf.add(Pair(first.first, k))
                        }

                    }

                    if (first.second == second.second) {
                        val i = first.first - second.first

                        if (i < 0) for (k in first.first..second.first) {
                            mutableListOf.add(Pair(k, first.second))
                        }
                        else for (k in first.first downTo second.first) {
                            mutableListOf.add(Pair(k, first.second))
                        }
                    }

                    if (first.first - second.first == first.second - second.second) {
                        val i = first.first - second.first

                        if (i < 0) for (k in first.first..second.first) {
                            mutableListOf.add(Pair(k, first.second))
                        }
                        else for (k in first.first downTo second.first) {
                            mutableListOf.add(Pair(k, first.second))
                        }
                    }

                    mutableListOf
                }.fold(mutableMapOf<Pair<Int, Int>, Int>()) { map, pair ->
                    if (map.contains(pair)) map[pair] = map[pair]?.plus(1)!!
                    else map[pair] = 1
                    map
                }.count { entry -> entry.value >= 2 }
        }

        fun part2(list: List<String>): Int {

            return list.map { parseInputLineToPairOfCoordinates(it) }
                .filter { vector ->
                    vector.first.first == vector.second.first
                            || vector.first.second == vector.second.second
                            || abs(vector.first.first - vector.second.first) == abs( vector.first.second - vector.second.second)
                }
                .flatMap { vector ->
                    val first = vector.first
                    val second = vector.second

                    val mutableListOf = mutableListOf(first, second)

                    if (first.first == second.first) {
                        val i = second.second - first.second
                        val increment = i / abs(i)

                        var incremented = first.second + increment
                        while (incremented != second.second) {
                            mutableListOf.add(Pair(first.first, incremented))
                            incremented += increment
                        }
                    }

                    if (first.second == second.second) {
                        val i = second.first - first.first
                        val increment = i / abs(i)

                        var incremented = first.first + increment
                        while (incremented != second.first) {
                            mutableListOf.add(Pair(incremented, first.second))
                            incremented += increment
                        }
                    }

                    if (abs(first.second - second.second) == abs(first.first - second.first)) {
                        val x = second.first - first.first
                        val y = second.second - first.second
                        val incrementX = x / abs(x)
                        val incrementY = y / abs(y)

                        var incrementedX = first.first + incrementX
                        var incrementedY = first.second + incrementY
                        while (incrementedX != second.first) {
                            mutableListOf.add(Pair(incrementedX, incrementedY))
                            incrementedX += incrementX
                            incrementedY += incrementY
                        }
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
    println(Day5.part1(readInput("Day05")))
    println(Day5.part2(readInput("Day05")))
}