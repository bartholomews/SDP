/**
  *
  */

import org.scalatest._

class ShufflerTest extends FlatSpec with Matchers {
  val s:Shuffler = new ShufflerImpl
  val array = Set('A', 'B', 'C')

  "Shuffler" should "shuffle" in {
    val arrayOneLetter = Set('A')
    s.shuffle(arrayOneLetter) should be ("AAAA")
  }

  "Test valid length" should "return a String with the chosen length" in {
    s.shuffle(array).length should be (s.length)
  }

}