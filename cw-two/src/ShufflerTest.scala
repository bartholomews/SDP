/**
  * Created by mba13 on 12/02/2016.
  */

import org.scalatest._

class ShufflerTest extends FlatSpec with Matchers {
  val s = new Shuffler

  "Shuffler" should "shuffle" in {
    val array = Array ('A')
    s.shuffle(array, 5) should be ("AAAAA")
  }

  "Test length" should "have the same length" in {
    val array = Array('A', 'B', 'C')
    s.shuffle(array, 5).length should be (5)
    s.shuffle(array, 100).length should be (100)
  }

}
