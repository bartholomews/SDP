package traits_inheritance

/**
  * Traits and Inheritance
  * (a)
  */
class Square(length: Double) extends Rectangular(length, length) {

  override def sides(): Int = 4

  override def perimeter(): Double = length * sides()

  override def area(): Double = square(length)

}
