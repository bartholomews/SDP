package traits_inheritance

/**
  * Traits and Inheritance
  * (a)
  */
class Rectangle(val width: Double, val length: Double) extends Shape {

  override def sides(): Int = 4

  override def perimeter(): Double = 2 * (length + width)

  override def area(): Double = width * length

}
