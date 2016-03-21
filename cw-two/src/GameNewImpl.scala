/**
  *
  */
class GameNewImpl(b: Boolean) extends GameAbstractImpl {
  // TODO inject these
  val colours: Colours = new ColoursImpl(Set("Blue", "Yellow", "Red", "Purple", "Green", "Orange"))
  val shuffler: Shuffler = new ShufflerImpl(4)
  val validator: Validator = new ValidatorImpl
  val guesses = 4 // TODO inject?
  val board: Board = new BoardImpl(guesses)

  @Override
  def runGames: Unit = {
    //   do {
    var again = false
    do {
      println("Welcome to Mastermind ...")
      println("This is a text version of the classic board game Mastermind.")
      print("The computer will think of a secret code. ")
      println("The code consists of " + shuffler.length + " colored pegs.")
      println("The pegs may be one of " + colours.colourSet.size + " colors: " + colours.colourSet.mkString(", "))
      print("A color may appear more than once in the code.\n" +
        "You try to guess what colored pegs are in the code and what order they are in.\n" +
        "After making a guess the result will be displayed.\n" +
        "A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.\n" +
        "For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n" +
        "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n" +
        "When entering guesses you only need to enter the first character of the color as a capital letter.\n" +
        "You have " + guesses + " tries to guess the answer or you lose the game.\n")

      var gameBoard = board.initBoard
      var attemptsLeft = guesses
      var won = false

      println("Generating secret code ....")
      val pegs: String = shuffler.shuffle(colours.getPegs())

      do {

        if (b) {
          println("The secret code is " + pegs)
        }

        board.printBoard(gameBoard)

        println("You have " + attemptsLeft + " attempts left")
        attemptsLeft = attemptsLeft - 1

        println("What is your next guess?")
        println("Type in the characters for your guess and press enter.")

        val input = validateInput()

        val result = validator.check(input.toList, pegs.toList)

        gameBoard = board.updateBoard(gameBoard, guesses - attemptsLeft, input, result)

        if(result.equals("Black " * shuffler.length)) won = true

      } while ((attemptsLeft > 0) && !won)

      if (won) println("You solved the puzzle! Good job.")
      else {
        board.printBoard(gameBoard)
        println("You did not solve the puzzle. Too bad.")
      }

      val playMore = scala.io.StdIn.readLine("Enter Y for another game or anything else to quit: ")
      if(playMore == "Y") again = true

    } while (again)
  }


  def validateInput(): String = {
    val input = scala.io.StdIn.readLine("Enter guess: ")
    if (!validator.validateString(input, colours.getPegs(), shuffler.length)) validateInput()
    else input
  }

}
