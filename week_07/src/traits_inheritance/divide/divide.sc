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