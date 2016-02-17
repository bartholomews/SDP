package named_and_default_args

import com.atomicscala.AtomicTest._

/**
  * Named & Default Arguments
  */
object SimpleTimeTest extends App {

  // 6.
  val t = new SimpleTime(hours=5, minutes=30)
  t.hours is 5
  t.minutes is 30

  // 7.
  val t2 = new SimpleTime2(hours=10)
  t2.hours is 10
  t2.minutes is 0

}
