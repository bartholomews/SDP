/**
  *
  */
class GameNewImpl(b: Boolean, guesses: Int) extends GameAbstractImpl {
  val modules = new GameModules()
  val colours: Colours = modules.colours
  val shuffler: Shuffler = modules.shuffler
  val validator: Validator = modules.validator
  val boardUtil: Board = modules.board(guesses)

  val pegs = colours.getPegs()

  @Override
  def runGames: Unit = {
    printIntro()
    play()
  }

  def play(): Unit = {
    println("Generating secret code ....")
    val code: String = shuffler.shuffle(colours.getPegs())
    val gameBoard = boardUtil.initBoard
    playSession(gameBoard, guesses, code)
    val playMore = scala.io.StdIn.readLine("Enter Y for another game or anything else to quit: ")
    if(playMore == "Y") play()
  }

  def playSession(board: Array[String], attemptsLeft: Int, code: String) {
    if (b) {
      println("The secret code is " + code + '\n')
    }
    boardUtil.printBoard(board)
    println("You have " + attemptsLeft + " attempts left")
    println("What is your next guess?")
    println("Type in the characters for your guess and press enter.")
    val input = validateInput()

    val result = validator.check(input.toList, code.toList)
    val newBoard = boardUtil.updateBoard(board, guesses - attemptsLeft + 1, input, result)

    if(result.equals("Black " * shuffler.length)) {
      val finalBoard = boardUtil.updateBoard(newBoard, input)
      boardUtil.printBoard(finalBoard)
      println ("You solved the puzzle! Good job.")
    }
    else if(attemptsLeft > 1) playSession(newBoard, attemptsLeft - 1, code)
    else println("You did not solve the puzzle. Too bad.")
  }

  def validateInput(): String = {
    val input = scala.io.StdIn.readLine("Enter guess: ")
    if (!validator.validateString(input, colours.getPegs(), shuffler.length)) validateInput()
    else input
  }

  def printIntro() = {
    println("Welcome to Mastermind ...")
    println("This is a text version of the classic board game Mastermind.")
    println("The computer will think of a secret code. \n")
    println("The code consists of " + shuffler.length + " colored pegs.")
    println("The pegs may be one of " + colours.colourSet.size + " colors: " + colours.colourSet.mkString(", "))
    println("A color may appear more than once in the code.\n")
    println("You try to guess what colored pegs are in the code and what order they are in.\n" +
      "After making a guess the result will be displayed.\n" +
      "A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.\n" +
      "For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n\n" +
      "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n" +
      "When entering guesses you only need to enter the first character of the color as a capital letter.\n\n" +
      "You have " + guesses + " tries to guess the answer or you lose the game.\n\n")
  }

}
