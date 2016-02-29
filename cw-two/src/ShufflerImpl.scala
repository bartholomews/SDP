import scala.util.Random

/**
  *
  */
class ShufflerImpl(val length: Int) extends Shuffler {

  def shuffle(array: List[Char]): String = {
    if(length <= 0) {
      throw new IndexOutOfBoundsException("Should return at least one peg!")
    }
    var s: String = ""
    for (n <- 1 to length) {
      val next = array(Random.nextInt(array.length))
      s += next
    }
    println(s)
    s
  }

}
