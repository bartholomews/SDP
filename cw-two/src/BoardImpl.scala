/**
  *
  */
class BoardImpl(val guesses: Int) extends Board {

  def initBoard:Array[String] = {
    val board = new Array[String](guesses + 1)
    board(0) = ".... Secret Code"
    for(x <- 1 until board.length) {
      board(x) = "...."
    }
    board
  }

  def updateBoard(board: Array[String], index: Int, attempt: String, code: String): Array[String] = {
    board(index) = attempt + " Result: " + code
    board
  }

  def updateBoard(board: Array[String], text: String): Array[String] = {
    board(0) = text
    board
  }

  def printBoard(board: Array[String]) = {
    board.foreach(x => println(x))
  }

}
