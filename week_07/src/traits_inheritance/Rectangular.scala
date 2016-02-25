package traits_inheritance

/**
  * Traits and Inheritance
  * (b)
  */
class Rectangular(val width: Double, val height: Double) extends Shape {

  override def sides() = 4

  override def perimeter() = 2 * (width + height)

  override def area() = width * height

}
