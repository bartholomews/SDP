/**
  * Shuffler interface to generate the secret code
  */
trait Shuffler {

  /**
    * Takes an Array of Chars (the set of 'Colours' in the game) and return a random sequence of pegs
    *
    * @param array the array of Chars out of which the code should be generated
    * @param length the number of pegs in the code
    */
  def shuffle(array: Array[Char], length: Int): String

}
