/**
  *
  */
class ColoursImpl(override val colourSet: Set[String]) extends Colours {

  def this() {
    this(Set(
      "blue",
      "green",
      "orange",
      "purple",
      "red",
      "yellow"
    ))
  }

  /**
    * Takes a set of Strings and return the first letter of each, capitalized
    *
    * @return the first letter of each String in colourSet, capitalized
    */
  override def getPegs: Set[Char] = colourSet.map(_.charAt(0).toUpper)

}
