package part_two

import com.atomicscala.AtomicTest._

/**
  * 27.
  */
case class P(first: String, last: String, email: String)

object TestPerson extends App {

  val p = P("Jane", "Smile", "jane@smile.com")
  p.first is "Jane"
  p.last is "Smile"
  p.email is "jane@smile.com"

  // 28.

  val people = Vector(
    P("Jane", "Smile", "jane@smile.com"),
    P("Ron", "House", "ron@house.com"),
    P("Sally", "Dove", "sally@dove.com")
  )
  people(0) is "P(Jane,Smile,jane@smile.com)"
  people(1) is "P(Ron,House,ron@house.com)"
  people(2) is "P(Sally,Dove,sally@dove.com)"

}
