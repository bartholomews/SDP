/**
  *
  */

import org.scalatest._

class ShufflerTest extends FlatSpec with Matchers {
  val s:Shuffler = new ShufflerImpl
  val array = List('A', 'B', 'C')

  "Shuffler" should "shuffle" in {
    val arrayOneLetter = List ('A')
    s.shuffle(arrayOneLetter, 5) should be ("AAAAA")
  }

  "Test valid length" should "return a String with the chosen length" in {
    s.shuffle(array, 5).length should be (5)
    s.shuffle(array, 10).length should be (10)
  }

  it should "throw IndexOutOfBoundsException if length is <= 0" in {
    a[IndexOutOfBoundsException] should be thrownBy {
      s.shuffle(array, 0)
    }
  }
 //todo test that the string generated is truly random
}