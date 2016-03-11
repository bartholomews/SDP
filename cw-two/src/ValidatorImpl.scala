/**
  *
  */
class ValidatorImpl extends Validator {

  override def validateString(s: String, set: Set[Char], length: Int): Boolean = {
    if(set.isEmpty || s.length != length) false
    else s.forall(c => set.contains(c))
  }

  def check(input: List[Char], code: List[Char]) = {
    val (black, white) = partition(input, code)
    println("Black" * black.length)
    val inputLeft = white.unzip._1
    val codeLeft = white.unzip._2
    codeLeft.foreach(c => {
      if(checkChar(c, inputLeft)) println ("White")
    })
  }

  def partition(input: List[Char], code: List[Char]) = {
    input.zip(code).partition(t => t._1 == t._2)
  }

  def checkChar(c: Char, l: List[Char]): Boolean = {
    if(l.isEmpty) false
    if(c.equals(l.head)) true
    else checkChar(c, l.drop(l.head))
  }

}
