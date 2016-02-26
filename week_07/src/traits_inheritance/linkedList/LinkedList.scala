package traits_inheritance.linkedList

import com.atomicscala.AtomicTest._

/**
  * Traits and Inheritance
  * (8.)
  */
sealed trait LinkedList[A]

final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

final case class Empty[A]() extends LinkedList[A]

object Test extends App {

  val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, Empty())))

  list.isInstanceOf[LinkedList[Int]] is true

  /* fields not defined in LinkedList...
  list.head
  list.tail.head
  list.tail.tail
  */

}
