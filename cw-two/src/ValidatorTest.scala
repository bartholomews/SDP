/**
  *
  */

import org.scalatest._

class ValidatorTest extends FlatSpec with Matchers {
  val v = new ValidatorImpl
  val set: Set[Char] = Set('A', 'B', 'C')


  // validateString() =========================================================================================


  "Validator" should "return false if input is wrong length" in {
    val input = "TEST"
    assert(!v.validateString(input, set, 3))
  }

  it should "return false if is within the set but wrong length" in {
    val input = "ABCA"
    assert(!v.validateString(input, set, 3))  }

  it should "return false if empty" in {
    val input = ""
    assert(!v.validateString(input, set, 3))  }

  it should "return false if is not within the set with right length" in {
    val input = "ZZZ"
    assert(!v.validateString(input, set, 3))  }

  it should "return false if is within the set, right length but lowercase" in {
    val input = "abc"
    assert(!v.validateString(input, set, 3))  }

  it should "return true if is within the set and right length and uppercase" in {
    val input = "ABC"
    assert(v.validateString(input, set, 3))
    val input2 = "AAA"
    assert(v.validateString(input2, set, 3))
  }

  //      =========================================================================================

  "CheckWhites" should "return empty string when no match" in {
    val input = List('A', 'S', 'D')
    val code = List('Z', 'Z', 'Z')
    assert(v.checkWhites(input, code).isEmpty)
  }

  it should "return empty string with empty input" in {
    val input = List()
    val code = List('Z', 'Z', 'Z')
    assert(v.checkWhites(input, code).isEmpty)
  }

  it should "return one match per guess even if code has more than one" in {
    val input = List('A', 'B', 'B')
    val code = List('B', 'Z', 'Z')
    assert(v.checkWhites(input, code).size == 1)
    assert(v.checkWhites(input, code).equals(List('B')))
  }

  it should "return one match per guess even if input has more than one" in {
    val input = List('A', 'A', 'A')
    val code = List('A', 'B', 'C')
    assert(v.checkWhites(input, code).size == 1)
    assert(v.checkWhites(input, code).equals(List('A')))
  }

  it should "return multiple matches" in {
    val input = List('A', 'B', 'C', 'D')
    val code = List('B', 'B', 'C', 'D', 'D')
    assert(v.checkWhites(input, code).size == 3)
    assert(v.checkWhites(input, code).equals(List('B', 'C', 'D')))
  }

  it should "return multiple matches of duplicated guesses/code" in {
    val input = List('A', 'B', 'A', 'C')
    val code = List('D', 'A', 'R', 'A')
    assert(v.checkWhites(input, code).size == 2)
    assert(v.checkWhites(input, code).equals(List('A', 'A')))
  }


  "splitLists_1" should "be the List of correct guesses: empty if none correct" in {
    val input = List('A', 'S', 'D')
    val code = List('Z', 'Z', 'Z')
    assert(v.splitLists(input, code)._1.isEmpty)
  }

  it should "be empty for correct guesses not in the right place" in {
    val input = List('A', 'S', 'D')
    val code = List('Z', 'D', 'S')
    assert(v.splitLists(input, code)._1.isEmpty)
  }

  it should "be a list of correct guesses at the right place" in {
    val input = List('A', 'S', 'D', 'Z')
    val code = List('A', 'D', 'S', 'Z')
    assert(v.splitLists(input, code)._1.nonEmpty)
    assert(v.splitLists(input, code)._1.size.equals(2))
    assert(v.splitLists(input, code)._1.equals(List('A', 'A'), ('Z', 'Z')))
  }

  it should "be a list of correct guesses at the right place with multiple duplicates" in {
    val input = List('A', 'A', 'D', 'Z')
    val code = List('A', 'A', 'S', 'D')
    assert(v.splitLists(input, code)._1.nonEmpty)
    assert(v.splitLists(input, code)._1.size.equals(2))
    assert(v.splitLists(input, code)._1.equals(List('A', 'A'), ('A', 'A')))
  }



}