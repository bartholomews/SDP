/**
  *
  */
class GameNewImpl(b: Boolean) extends GameAbstractImpl {
  // TODO inject these
  val colours: Colours = new ColoursImpl(Set("Blue", "Yellow", "Red", "Purple", "Green", "Orange"))
  val shuffler: Shuffler = new ShufflerImpl(4)

  val guesses = 12  // TODO inject?

  @Override
  def runGames: Unit = {
    val won = false
    //   do {
    var attemptsLeft = guesses
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

      println("Generating secret code ....")
      val pegs: String = shuffler.shuffle(colours.getPegs())

      do {

        if(b) {
        println("The secret code is " + pegs)
        }

        attemptsLeft = attemptsLeft - 1
        println("You have " + attemptsLeft + " attempts left")

        // game

      } while ((attemptsLeft > 0) && !won)


      again = false

    } while(again)
  }
}
          /*
          blue, green , orange, purple, red, or yellow.

          //run a game:
        //print intro text
        //generate the code
        //take the guess (and count guesses)
        //check the guess against code
        //print out white/black/etc
        finish = true
      } while(!finish)
      //12 or fewer attempts, then game over //while not correct guess
      //print game over text
      //ask if wants new game
 //   } while //not quit
  }

}

*/
