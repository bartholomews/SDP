/**
  *
  */
class ColoursImpl extends Colours {

 //val s: Set[String] = Set("Blue", "ASD")

  /**
    * Takes a set of Strings and return the first letter of each, capitalized
    *
    * @param colours the set of valid colours
    * @return the first letter of each, capitalized
    */
  override def getPegs(colours: Set[String]): List[Char] = colours.map(_.charAt(0).toUpper).toList
}
