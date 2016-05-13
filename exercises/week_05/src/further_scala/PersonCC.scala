package further_scala

import com.atomicscala.AtomicTest._

/**
  * 10.
  */
case class PersonCC(firstName: String, lastName: String)

object PersonCC {
  // overloading apply(firstName, lastName) from case class
  def apply(name: String) =
    new PersonCC(name.split(" ")(0), name.split(" ")(1))
}

object PersonTestCC extends App {
  val p: PersonCC = PersonCC.apply("John Doe")
  p.firstName is "John"
  p.lastName is "Doe"

  val p2 = PersonCC.apply("John", "Doe")
  p2.firstName is "John"
  p2.lastName is "Doe"
}