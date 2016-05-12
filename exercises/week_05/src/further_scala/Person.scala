package further_scala

import com.atomicscala.AtomicTest._

/**
  * 4.
  */
class Person(val firstName: String, val lastName: String)

object Person {
  def apply(name: String) =
    new Person(name.split(" ")(0), name.split(" ")(1))
}

object PersonTest extends App {
  val p: Person = Person.apply("John Doe")
  p.firstName is "John"
  p.lastName is "Doe"
}