package classes_and_objects

/**
  * 1. Methods inside Classes
  */
object Test {

  def main(args: Array[String]) {

    val sailboat = new Sailboat

    /**
      * This test fails: the methods raise() and lower()
      * print the correct String but return a Unit type
      */
    val r1 = sailboat.raise()
    assert(r1 == "Sails raised", "Expected Sails, raised, Got " + r1)
    val r2 = sailboat.lower()
    assert(r2 == "Sails lowered", "Expected Sails lowered, Got " + r2)

    val motorboat = new Motorboat

    /**
      * This test is successful, the methods return a String type
      */
    val s1 = motorboat.on()
    assert(s1 == "Motor on", "Expected Motor on, Got " + s1)
    val s2 = motorboat.off()
    assert(s2 == "Motor off", "Expected Motor off, Got " + s2)

  }

}
