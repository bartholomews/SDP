package traits_inheritance.shape

import scala.math._

/**
  * Traits and Inheritance
  * (5)
  */
sealed trait Shape {
  def sides(): Int
  def perimeter(): Double
  def area(): Double
  val colour: Colour

  def square(n: Double) = n * n
}

abstract class Rectangular(width: Double, height: Double, colour: Colour) extends Shape {
  override def sides() = 4
  override def perimeter() = 2 * (width + height)
  override def area() = width * height
}

case class Circle(radius: Double, colour: Colour) extends Shape {
  override def sides(): Int = 0
  override def perimeter(): Double = 2 * Pi * radius
  override def area(): Double = Pi * square(radius)
}

case class Rectangle(width: Double, height: Double, colour: Colour)
  extends Rectangular(width, height, colour) with Shape {}

case class Square(length: Double, colour: Colour)
  extends Rectangular(length, length, colour) with Shape {}
