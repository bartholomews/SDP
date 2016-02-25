package traits_inheritance

/**
  * Traits and Inheritance
  * (a)
  */
trait Shape {

  def sides(): Int

  def perimeter(): Double

  def area(): Double

  def square(n: Double) = n * n

}