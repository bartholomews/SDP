package traits_inheritance

/**
  *
  */
object Draw extends App {

  def apply(s: Shape):Unit = s match {
    case Circle(r) => println("A circle of radius " + r + "cm")
    case Rectangle(w, h) => println("A rectangle of width " + w + " and height " + h)
    case Square(l) => println("A square of length " + l)
  }

  Draw(Circle(10))
  Draw(Rectangle(3, 4))
  Draw(Square(5))

}
