package part_two

import com.atomicscala.AtomicTest._

/**
  * 28.
  */
case class Name(firstName: String, lastName: String)

object TestName extends App {

  val m = Map("sally@taylor.com" -> Name("Sally", "Taylor"))
  m("sally@taylor.com") is Name("Sally", "Taylor")

  // 29.

  val m2 = Map(m.head, "jiminy@cricket.com" -> Name("Jiminy", "Cricket"))
  m2("jiminy@cricket.com") is Name("Jiminy", "Cricket")
  m2("sally@taylor.com") is Name("Sally", "Taylor")

}