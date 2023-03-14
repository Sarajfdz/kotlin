data class MinesweeperBoard(val inputBoard: List<String>) {

    // TODO: Implement proper constructor

    fun withNumbers(): List<String> =
        inputBoard.mapIndexed { row, inputStr-> //The inputB is the list of strings
            inputStr.mapIndexed { col, cell -> when (cell) { //Map applied to a string
                ' ' -> adjacentMines(row, col)
                else -> cell
            }
            }.joinToString("")

        }

    private fun adjacentMines(row: Int, col: Int): Char {
        var count = 0;
        var rangeRow = Math.max(0, row - 1)..Math.min(inputBoard.size - 1, row + 1);
        var rangeCol = Math.max(0, col - 1)..Math.min(inputBoard[0].length - 1, col + 1);
        for (i in rangeRow){
            for (j in rangeCol){
                if (inputBoard[i][j] =='*'){
                    count=count+1
                } else{
                    count=count
                }
            }
        }
        return if (count > 0) (count + 48).toChar() else ' '
    }
}