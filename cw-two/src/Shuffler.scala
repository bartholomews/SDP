import scala.util.Random

/**
  *
  */
class Shuffler {

  def shuffle(array: Array[Char], length: Int): String = {
    if(length <= 0) {
      throw new IndexOutOfBoundsException("Should return at least one peg!")
    }
    var s: String = ""
    for (n <- 1 to length) {
      val next = array(Random.nextInt(array.length))
      s += next
    }
    s
  }

}
