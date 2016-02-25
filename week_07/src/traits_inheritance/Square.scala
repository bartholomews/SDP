package traits_inheritance

/**
  * Traits and Inheritance
  * (a)
  */
class Square(val length: Double) extends Shape {

  override def sides(): Int = 4

  override def perimeter(): Double = length * sides()

  override def area(): Double = square(length)

}
