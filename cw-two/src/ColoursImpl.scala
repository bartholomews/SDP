/**
  *
  */
class ColoursImpl(override val colourSet: Set[String]) extends Colours {

  // TODO chars should not have repeating first letters

  /**
    * Takes a set of Strings and return the first letter of each, capitalized
    *
    * @return the first letter of each String in colourSet, capitalized
    */
  override def getPegs(): List[Char] = colourSet.map(_.charAt(0).toUpper).toList

}
