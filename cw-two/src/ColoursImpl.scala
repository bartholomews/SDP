/**
  *
  */
class ColoursImpl extends Colours {

 // val s: Set[String] = Set("Blue", "ASD")

  /**
    * Takes a set of Strings and return the first letter of each, capitalized
    *
    * @param colours the set of valid colours
    * @return the first letter of each, capitalized
    */
  override def getPegs(colours: Set[String]): Array[Char] = {
    var pegs: Array[Char] = new Array[Char](colours.size)
    colours.foreach {
      s => pegs.apply(s.charAt(0).toUpper)
        println(s.charAt(0).toUpper)
      println(pegs.mkString("\n"))
    }
    pegs
  }
}
