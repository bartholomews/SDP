/**
  *
  */
trait Colours {

  /**
    * The set of valid colours.
    */
  val colours: Set[String] = Set()

  /**
    * Takes a set of Strings and return the first letter of each, capitalized
    *
    * @param strings the set of valid colours
    * @return the first letter of each, capitalized
    */
  def getPegs(strings: Set[String]): List[Char]

}
