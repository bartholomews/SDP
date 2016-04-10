

/**
  * Implementation of `Validator` trait.
  *
  * @author annabel.jump, federico.bartolomei
  */
class ValidatorImpl extends Validator {

  override def validateString(s: String, set: Set[Char], length: Int): Boolean = {
    if(set.isEmpty || s.length != length) false
    else s.forall(c => set.contains(c))
  }

  override def check(input: List[Char], code: List[Char]):Result = {
    val (black, white) = splitLists(input, code)
    val inputLeft = white.unzip._1
    val codeLeft = white.unzip._2
    val result = "Black " * black.size + "White " * checkWhites(inputLeft, codeLeft).size
    if(result == "Black " * code.size) Won(result)
    else if(result.isEmpty) NotWon("No Pegs")
    else NotWon(result)
  }

  def splitLists(input: List[Char], code: List[Char]) = {
    input.zip(code).partition(t => t._1 == t._2)
  }

  def checkWhites(input: List[Char], code: List[Char]): List[Char] = {
    input.intersect(code)
  }

}
