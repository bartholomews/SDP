/**
  *
  */
class ColoursImpl() extends Colours {

  override val colourSet = Set("blue", "yellow", "red", "purple", "green", "orange")

  /**
    * Takes a set of Strings and return the first letter of each, capitalized
    *
    * @return the first letter of each String in colourSet, capitalized
    */
  override def getPegs(): Set[Char] = colourSet.map(_.charAt(0).toUpper)

}
