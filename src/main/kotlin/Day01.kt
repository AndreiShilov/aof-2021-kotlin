fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

fun part1(input: List<String>): Int {
    return part1Int(input.map { it.toInt() })

}

fun part1Int(input: List<Int>): Int {
    return input.windowed(2)
        .count { pair -> pair[1] > pair[0] }
}

fun part2(input: List<String>): Int {
    val sumList = input.map { it.toInt() }.windowed(3).map { list -> list.sum() }
    return part1Int(sumList)
}
