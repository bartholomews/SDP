package traits_inheritance.sum

import com.atomicscala.AtomicTest._

/**
  * Traits and Inheritance
  * (9.)
  */
sealed trait Sum[A, B]

final case class Left[A, B](value: A) extends Sum[A, B]

final case class Right[A, B](value: B) extends Sum[A, B]

object SumTest extends App {

  Left[Int, String](1).value is 1
  Right[Int, String]("foo").value is "foo"

  val sum: Sum[Int ,String] = Right("foo")

  val res26 = sum match {
    case Left(x) => x.toString
    case Right(x) => x
  }

  res26.isInstanceOf[String] is true
  res26 is "foo"


}