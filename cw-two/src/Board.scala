/**
  *
  */
trait Board {

  val guesses: Int
  def initBoard: Array[String]
  def updateBoard(board: Array[String], index: Int, attempt: String, code: String): Array[String]
  def printBoard(board: Array[String])
}
