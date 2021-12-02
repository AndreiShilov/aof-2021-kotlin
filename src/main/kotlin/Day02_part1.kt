class Submarine(var horizontalPosition: Int = 0, var depth: Int = 0, var aim: Int = 0) {

    fun executeCommand(command: Command) {
        command.moveSubmarine(this)
    }

    fun getCurrentPosition(): Int {
        return horizontalPosition * depth
    }

    override fun toString(): String {
        return "Submarine(horizontalPosition=$horizontalPosition, depth=$depth)"
    }
}


sealed class Command(var value: Int) {
    abstract fun moveSubmarine(submarine: Submarine)
}

class Forward(value: Int) : Command(value) {
    override fun moveSubmarine(submarine: Submarine) {
        submarine.horizontalPosition += value
        submarine.depth += submarine.aim * value
    }
}

class Down(value: Int) : Command(value) {
    override fun moveSubmarine(submarine: Submarine) {
        submarine.aim += value
    }
}

class Up(value: Int) : Command(value) {
    override fun moveSubmarine(submarine: Submarine) {
        submarine.aim -= value
    }
}

fun commandFromInput(commandString: String): Command {
    val commandSplit = commandString.split(" ")
    val value = commandSplit[1].toInt()
    return when (commandSplit[0]) {
        "forward" -> Forward(value)
        "down" -> Down(value)
        "up" -> Up(value)
        else -> throw IllegalArgumentException("Non existing command")
    }
}

fun main() {

    println(part2Day2(readInput("Day02_test")))
    println(part2Day2(readInput("Day02")))
}

fun part2Day2(input: List<String>): Int {
    val submarine = Submarine()
    input.map { commandFromInput(it) }.forEach { submarine.executeCommand(it); println(submarine) }

    return submarine.getCurrentPosition()
}

