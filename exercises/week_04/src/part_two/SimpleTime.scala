package part_two

import com.atomicscala.AtomicTest._

/**
  * 24.
  */
class SimpleTime(val hours: Int, val minutes: Int)

// 25.
class SimpleTime2(val hours: Int, val minutes: Int = 0)

object Test extends App {

  val t = new SimpleTime(hours = 5, minutes = 30)
  t.hours is 5
  t.minutes is 30

  val t2 = new SimpleTime2(hours = 10)
  t2.hours is 10
  t2.minutes is 0

}