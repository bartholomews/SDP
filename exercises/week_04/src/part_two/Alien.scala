package part_two

/**
  * 10(b).
  * greet is a method of type String, cannot be used to greet other object.
  *
  */
object Alien {

  /* Person is an object = singleton, cannot be passed as argument
  def greet(p: Person) = "Hello, " + p.firstName
  */

  def greet = "Hello, " + Person.firstName

  // 11. Methods are expressions, they don't get evaluated
  // as soon as they are declared (as in the case of values)

}
