package traits_inheritance.pair

import com.atomicscala.AtomicTest._

/**
  * Traits and Inheritance
  * (8.)
  */
class Pair[A, B](val one: A, val two: B)

object PairTest extends App {

  val pair = Pair[String, Int]("hi", 2)
  pair._1 is "hi"
  pair._2 is 2

}
