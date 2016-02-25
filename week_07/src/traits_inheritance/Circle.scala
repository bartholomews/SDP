package traits_inheritance

import scala.math.Pi

/**
  * Traits and Inheritance
  * (a)
  */
class Circle(val radius: Int) extends Shape {

  override def sides(): Int = 0

  override def perimeter(): Double = 2 * Pi * radius

  override def area(): Double = Pi * square(radius)

}
