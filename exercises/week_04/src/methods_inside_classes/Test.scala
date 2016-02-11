package methods_inside_classes

/**
  * 1. Methods inside Classes
  */
object Test {

  def main(args: Array[String]) {

    val sailboat = new Sailboat

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

    // 2.
    val flare = new Flare()
    val f1 = flare.light()
    assert(f1 == "Flare used!", "Expected Flare used! Got " + f1)

    // 3.
    val sailboat2 = new Sailboat
    val signal = sailboat2.signal()
    assert(signal == "Flare used!", "Expected Flare used! Got " + signal)

    // 3.
    val motorboat2 = new Motorboat
    val flare2 = motorboat2.signal()
    assert(flare2 == "Flare used!", "Expected Flare used! Got " + flare2)

  }

}
