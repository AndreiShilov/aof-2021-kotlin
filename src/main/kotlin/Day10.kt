import java.util.*

val bracketsMapping = mapOf(
    '>' to 25137,
    '}' to 1197,
    ']' to 57,
    ')' to 3
)

val closedSet = setOf("<>", "{}", "[]", "()")
val closing = setOf('>', '}', ']', ')')
val closingMap = mapOf(
    '<' to 4,
    '{' to 3,
    '[' to 2,
    '(' to 1,
)

class Day10 {

    companion object {

        fun part1(input: List<String>): Int {
            return input.sumOf { processLine(it) }
        }

        fun part2(input: List<String>): Long {
            val sorted = input.filter { processLine(it) == 0 }.map { processIncomplete(it) }.sorted()
            println(sorted)
            return sorted[(sorted.size - 1) / 2]
        }

        private fun processIncomplete(incomplete: String): Long {
            val stack = Stack<Char>()
            val toCharArray = incomplete.toCharArray()

            for (it in toCharArray) {
                if (stack.empty()) {
                    stack.push(it); continue
                }

                val element = String(charArrayOf(stack.peek(), it))
                if (closedSet.contains(element)) {
                    stack.pop(); continue
                }
                stack.push(it)
            }

            var result = 0L

            while (stack.isNotEmpty()) {
                result = result * 5 + closingMap[stack.pop()]!!
            }

            return result
        }

        private fun processLine(line: String): Int {
            val stack = Stack<Char>()
            val toCharArray = line.toCharArray()

            var result = 0

            for (it in toCharArray) {
                if (stack.empty()) {
                    stack.push(it); continue
                }

                val element = String(charArrayOf(stack.peek(), it))
                if (closedSet.contains(element)) {
                    stack.pop(); continue
                } else if (closing.contains(it)) {
                    result = bracketsMapping[it]!!; break
                }
                stack.push(it)
            }

            return result
        }
    }
}

fun main() {
    println(Day10.part1(readInput("Day10")))
    println(Day10.part2(readInput("Day10")))
}
