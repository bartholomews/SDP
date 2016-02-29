/**
  * Shuffler interface to generate the secret code
  */
trait Shuffler {

  val length: Int

  /**
    * Takes a List of Chars (the set of 'Colours' in the game) and return a random sequence of pegs
    * of length 'n'
    *
    * @param array the array of Chars out of which the code should be generated
    */
  def shuffle(array: Set[Char]): String

}
