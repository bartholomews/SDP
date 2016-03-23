import scala.util.Random

/**
  *
  */
class ShufflerImpl() extends Shuffler {

  val length = 4

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
