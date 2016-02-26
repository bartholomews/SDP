package traits_inheritance.shape

/**
  * Traits and Inheritance
  * (5)
  */
object Draw extends App {

  def apply(s: Shape):Unit = s match {
    case Circle(r: Double, c: Colour) =>
      val s = "A circle of radius " + r
      matchColour(s, c)
    case Rectangle(w, h, c) =>
      val s = "A rectangle of width " + w + ", height " + h
      matchColour(s, c)
    case Square(l, c) =>
      val s = "A square of length " + l
      matchColour(s, c)
  }

  def matchColour(s: String, c: Colour) = c match {
    case Pink() => stringAndColourName(s, c)
    case Yellow() => stringAndColourName(s, c)
    case Red() => stringAndColourName(s, c)
    case _ =>
      val b = if (c.Dark()) "dark" else "light"
      println(s + " and " + b)
  }

  def stringAndColourName(s: String, c: Colour): Unit = {
    println(s + " and " + c.name)
  }

  Draw(Circle(10, Colour.newColour("Dark Slate Blue", 72, 61, 139)))
  Draw(Rectangle(3, 4, Red()))
  Draw(Square(5, Pink()))

}
