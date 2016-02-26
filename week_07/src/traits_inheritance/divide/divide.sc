/**
  * Traits and Inheritance
  * (6.)
  */

sealed trait DivisionResult

final case class Finite(result: Int) extends DivisionResult

final case class Infinite() extends DivisionResult

object divide extends App {
  def apply(x: Int, y: Int): DivisionResult = if (y == 0) Infinite() else Finite(x/y)
}

divide(1, 2)
divide(1, 0)

def div(x: Int, y: Int) = {
  divide(x, y) match {
    case Finite(z) => println(x + " / " + y + " = " + z)
    case Infinite() => println("Cannot divide by zero!")
  }
}

div(1, 2)
div(1, 0)

/**
  * Traits and Inheritance
  * (10.)
  */

sealed trait Maybe[A]

final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]

object genericDivide {
  def apply(x: Int, y: Int):Maybe[Int] = {
    if (y == 0) Empty() else Full[Int](x/y)
  }
}

genericDivide(1, 0) match {
  case Full(value) => println(s"It's finite: $value")
  case Empty() => println(s"It's infinite")
}