package traits_inheritance

import scala.math._

/**
  * Traits and Inheritance
  * (a)
  */
sealed trait Shape {
  def sides(): Int
  def perimeter(): Double
  def area(): Double
  def square(n: Double) = n * n
}

abstract class Rectangular(width: Double, height: Double) extends Shape {
  override def sides() = 4
  override def perimeter() = 2 * (width + height)
  override def area() = width * height
}

case class Circle(val radius: Int) extends Shape {
  override def sides(): Int = 0
  override def perimeter(): Double = 2 * Pi * radius
  override def area(): Double = Pi * square(radius)
}

case class Rectangle(width: Double, height: Double) extends Rectangular(width, height) with Shape {}

case class Square(length: Double) extends Rectangular(length, length) with Shape {}

