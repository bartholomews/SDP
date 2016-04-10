import org.scalatest.{FlatSpec, Matchers}

/**
  *
  */
class ColoursTest extends FlatSpec with Matchers {

  // "blue", "green", "orange", "purple", "red", "yellow"
  val colours: Colours = new ColoursImpl()

  "getPegs" should "get a set of Strings and return a Set of Char" in {
    colours.getPegs shouldBe a [Set[Char]]
  }

  "getPegs" should "return same length as fed Set" in {
    val charArray = colours.getPegs
    charArray.size should be (6)
  }

  "getPegs on empty Set[String]" should "return an empty Set[Char]" in {
    val emptySet: Set[String] = Set()
    val emptyColours = new ColoursImpl(emptySet)
    emptyColours.getPegs shouldBe a [Set[Char]]
    emptyColours.getPegs shouldBe empty

  }

  "getPegs" should "return the first letters capitalized of each String in Set fed" in {
    val charList = colours.getPegs
    charList should contain ('Y')
    charList should not contain 'y'
    charList should contain ('G')
    charList should not contain 'g'
    charList should contain ('O')
    charList should not contain 'o'
  }


}
