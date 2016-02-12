import org.scalatest.{Matchers, FlatSpec}

/**
  *
  */
class ColoursTest extends FlatSpec with Matchers {
  val colours: Colours = new ColoursImpl
  val stringSet: Set[String] = Set ("bLUE", "yellow", "GREEN")

  "getPegs" should "get a set of Strings and return an Array of Char" in {
    colours.getPegs(stringSet) shouldBe a [Array[Char]]
  }

  "getPegs" should "return same length as fed Set" in {
    val charArray = colours.getPegs(stringSet)
    charArray.length should be (3)
  }

  "getPegs" should "return the first letter capitalized of fed Set" in {
    val colours2: Colours = new ColoursImpl
    val charArray = colours2.getPegs(stringSet)

    charArray(0) should be ('B')
    charArray(1) should be ('Y')
    charArray(2) should be ('G')
  }




}
