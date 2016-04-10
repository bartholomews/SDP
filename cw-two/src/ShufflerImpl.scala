import scala.util.Random

/**
  * Implementation of `Shuffler` trait.
  *
  * @author annabel.jump, federico.bartolomei
  */
class ShufflerImpl(val length: Int) extends Shuffler {

  def this() {
    this(4)
  }

  def shuffle(set: Set[Char]): String = {
    val list = set.toList
    if(length <= 0 || set.isEmpty) {
      throw new IllegalArgumentException("Should return at least one peg!")
    }
    var s: String = ""
    for (n <- 1 to length) {
      val next = list(Random.nextInt(list.length))
      s += next
    }
    s
  }

}
