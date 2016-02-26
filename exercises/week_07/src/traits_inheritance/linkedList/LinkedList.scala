package traits_inheritance.linkedList

import com.atomicscala.AtomicTest._

/**
  * Traits and Inheritance
  * (8.)
  */
sealed trait LinkedList[A] {
  def length: Int
  def apply(i: Int): A
  def contains(x: A): Boolean
}

final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A] {

  override def length: Int = {
    tail match {
      case Empty() => 1
      case Pair(h, t) => 1 + tail.length
    }
  }

  override def apply(i: Int):A = {
    if(i<0) throw new IndexOutOfBoundsException(i + ": index out of bounds")
    if(i==0) this.head
    else this.tail.apply(i-1)
  }
  override def contains(x: A): Boolean = {
    if(x == this.head) true
    else tail.contains(x)
  }
}

final case class Empty[A]() extends LinkedList[A] {
  override def length: Int = 0
  override def apply(i: Int) = throw new IndexOutOfBoundsException(i + ": index out of bounds")
  override def contains(x: A): Boolean = false
}

object Test extends App {

  val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, Empty())))
  list.isInstanceOf[LinkedList[Int]] is true
  list.length is 3
  list.apply(0) is 1
  list.apply(1) is 2
  list.apply(2) is 3
  list.contains(3) is true
  list.contains(-1) is false

  val emptyList: LinkedList[Int] = Empty()
  emptyList.length is 0
  emptyList.contains(2) is false

  /* fields not defined in LinkedList...
  list.head
  list.tail.head
  list.tail.tail
  */

}
