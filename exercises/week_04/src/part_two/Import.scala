package part_two

/**
  * 12.
  */
class Import {

  import trivial.A
  val a = new A
//  val b = new B
//  val c = new C

  import trivial.{A, B}
  val a2 = new A
  val b2 = new B
  //  val c2 = new C

  import trivial._
  val a3 = new A
  val b3 = new B
  val c3 = new C

}
