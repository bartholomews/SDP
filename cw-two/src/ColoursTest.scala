import org.scalatest.{FlatSpec, Matchers}

/**
  *
  */
class ColoursTest extends FlatSpec with Matchers {
  val colours: Colours = new ColoursImpl()

  "getPegs" should "get a set of Strings and return an Array of Char" in {
    colours.getPegs() shouldBe a [Array[Char]]
  }

  "getPegs" should "return same length as fed Set" in {
    val charArray = colours.getPegs()
    charArray.size should be (6)
  }

  "getPegs" should "return the first letter capitalized of fed Set" in {
    val charList = colours.getPegs()

    charList.head should be ('B')
    charList(1) should be ('Y')
    charList(2) should be ('R')
  }




}
