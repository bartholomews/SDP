/**
  *
  */

import org.scalatest._

class ShufflerTest extends FlatSpec with Matchers {
  val s:Shuffler = new ShufflerImpl(5)
  val s2: Shuffler = new ShufflerImpl(10)
  val array = List('A', 'B', 'C')

  "Shuffler" should "shuffle" in {
    val arrayOneLetter = List ('A')
    s.shuffle(arrayOneLetter) should be ("AAAAA")
  }

  "Test valid length" should "return a String with the chosen length" in {
    s.shuffle(array).length should be (5)
    s2.shuffle(array).length should be (10)
  }

  it should "throw IndexOutOfBoundsException if length is <= 0" in {
    val emptyShuffler: Shuffler = new ShufflerImpl(0)
    a[IndexOutOfBoundsException] should be thrownBy {
      emptyShuffler.shuffle(array)
    }
  }
 //todo test that the string generated is truly random
}