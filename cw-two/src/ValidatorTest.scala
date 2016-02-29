/**
  *
  */

import org.scalatest._

class ValidatorTest extends FlatSpec with Matchers {
  val v: Validator = new ValidatorImpl
  val set: Set[Char] = Set('A', 'B', 'C')


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



}