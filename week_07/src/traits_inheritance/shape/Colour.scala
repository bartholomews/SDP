package traits_inheritance.shape

/**
  * Traits and Inheritance
  * (d)
  */
sealed trait Colour {
  val name: String
  val r: Int
  val g: Int
  val b: Int
  def Dark(): Boolean = { r < 190 && g < 190 && b < 190 }
  def Light(): Boolean = { r >= 190 || g >=190 || b >= 190}
}

case class Red() extends Colour {
  val name = "Red"
  val r = 255
  val g = 0
  val b = 0
}

case class Yellow() extends Colour {
  val name = "Yellow"
  val r = 255
  val g = 255
  val b = 0
}

case class Pink() extends Colour {
  val name = "Yellow"
  val r = 255
  val g = 192
  val b = 203
}

object Colour {

  def newColour(s: String, r: Int, g: Int, b: Int): Colour = {
    new Colour {
      override val name = s
      override val r: Int = r
      override val g: Int = g
      override val b: Int = b
    }
  }

}







