/**
  * Trait to implement the Colours of the Mastermind game
  *
  * @author annabel.jump, federico.bartolomei
  */
trait Colours {

  /**
    * The set of valid colours.
    */
  val colourSet: Set[String] = Set()

  /**
    * Takes a set of Strings and return the first letter of each, capitalized
    *
    * @return the first letter of each String in colourSet, capitalized
    */
  def getPegs: Set[Char]

}
