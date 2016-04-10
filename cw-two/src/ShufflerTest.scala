/**
  *
  */

import org.scalatest._

class ShufflerTest extends FlatSpec with Matchers {
  val shufflerSized4 = new ShufflerImpl()
  val testArray = Set('A', 'B', 'C')

  "Shuffling an empty set" should "throw an IllegalArgumentException" in {
    val emptySet: Set[Char] = Set()
    intercept[IllegalArgumentException] {
      shufflerSized4.shuffle(emptySet)
    }
  }

  "Shuffling with length <= 0" should "throw an IllegalArgumentException" in {
    val set: Set[Char] = Set('A', 'B', 'C')
    val invalidShuffler = new ShufflerImpl(0)
    intercept[IllegalArgumentException] {
      invalidShuffler.shuffle(set)
    }
  }

  "Shuffler" should "shuffle set of size 1 'n' times" in {
    val n = 5
    val shufflerSize5 = new ShufflerImpl(n)
    val arrayOneLetter = Set('A')
    shufflerSize5.shuffle(arrayOneLetter) should be ("AAAAA")
  }

  "Shuffling twice a large set" should "really not return the same result" in {
    val n = 10000
    val shufflerSize100 = new ShufflerImpl(n)
    val arrayTwoLetters = Set('A', 'B')
    val test1 = shufflerSize100.shuffle(arrayTwoLetters)
    val test2 = shufflerSize100.shuffle(arrayTwoLetters)
    test1 should(not be eq(test2))
  }

}