import scala.util.Random

/**
  *
  */
class ShufflerImpl(val length: Int) extends Shuffler {

  def shuffle(set: Set[Char]): String = {
    val list = set.toList
    if(length <= 0) {
      throw new IndexOutOfBoundsException("Should return at least one peg!")
    }
    var s: String = ""
    for (n <- 1 to length) {
      val next = list(Random.nextInt(list.length))
      s += next
    }
    s
  }

}
