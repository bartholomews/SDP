/**
  *
  */
class ValidatorImpl extends Validator {

  override def validateString(s: String, set: Set[Char], length: Int): Boolean = {
    if(s.length != length) false
    else s.forall(c => set.contains(c))
  }

  def findBlacks(): List[(Char, Char)] = {
    val pegs = List ('A','B','C')
    val list = List ('A', 'Z', 'Z')
    val zipped: List[(Char, Char)] = list.zip(pegs)

    zipped.productIterator.foreach{t => println(t)}


    return zipped

    //zipped.partition((_,_) =>


  }
}
