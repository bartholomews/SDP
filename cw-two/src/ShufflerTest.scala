/**
  * Created by mba13 on 12/02/2016.
  */

import org.scalatest._

class ShufflerTest extends FlatSpec with Matchers {
  val s:Shuffler = new ShufflerImpl
  val array = Array('A', 'B', 'C')

  "Shuffler" should "shuffle" in {
    val arrayOneLetter = Array ('A')
    s.shuffle(arrayOneLetter, 5) should be ("AAAAA")
  }

  "Test valid length" should "return a String with the chosen length" in {
    s.shuffle(array, 5).length should be (5)
    s.shuffle(array, 100).length should be (100)
  }

  it should "throw IndexOutOfBoundsException if length is <= 0" in {
    a[IndexOutOfBoundsException] should be thrownBy {
      s.shuffle(array, 0)
    }
  }

}
