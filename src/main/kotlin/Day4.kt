class Day4 {

    companion object {

        fun part1(input: List<String>): Int {
            return BingoGame(input).play()
        }
    }

}


fun main() {
    val result = Day4.part1(readInput("Day04"))
    println(result)
}


class BingoGame(input: List<String>) {
    private val numbers: Array<Int>
    private val boards: List<BingoBoard>

    init {
        this.numbers = input[0].split(",").map { it.toInt() }.toTypedArray()
        this.boards = parseBoardsInput(input.drop(1))
    }

    fun play(): Int {
        for (number in numbers) {
            for (board in boards) {
                if (board.newRound(number)) {
                    return board.sumUnmarked() * number
                }
            }
        }


        return 0
    }

    private fun parseBoardsInput(boardsInput: List<String>): List<BingoBoard> {
        return boardsInput.chunked(6).map { BingoBoard(it.drop(1)) }
    }
}

class BingoBoard(boardInput: List<String>) {
    private val board: List<Array<Int>>

    init {
        this.board = boardInput.map { it.split(" ").filter { it != "" }.map { it.toInt() }.toTypedArray() }
    }

    fun newRound(roundValue: Int): Boolean {

        for (x in board.indices) {
            for (y in board[x].indices) {
                val currentValue: Int = board[x][y]
                if (currentValue == roundValue) {
                    board[x][y] = -1
                    return checkIfWon(x, y)
                }
            }
        }
        return false
    }

    private fun printBoard() {
        for (x in board.indices) {
            for (y in board[x].indices) {
                print(" " + board[x][y])
            }
            print("\n")
        }
    }

    private fun checkIfWon(x: Int, y: Int): Boolean {
        var resultRow = 0
        var resultColumn = 0

        for (i in board.indices) {
            resultRow += board[x][i]
            resultColumn += board[i][y]
        }

        return resultRow == -5 || resultColumn == -5
    }

    fun sumUnmarked(): Int {
        return this.board.sumOf { it -> it.filter { it > -1 }.sum() }
    }

}