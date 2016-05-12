package further_scala

import com.atomicscala.AtomicTest._

/**
  * 1.
  */
class Counter(n: Int) {
  // 1.
  val count = n
  def inc = new Counter(n + 1)
  def dec = new Counter(n - 1)
  // 2.
  def inc(i: Int = 1) = new Counter(n + i)
  def dec(d: Int = 1) = new Counter(n - d)
  // 3.
  def adjust(a: Adder, in: Int) = new Counter(a.add(in))

}

object TestCounter extends App {
  // 1.
  val test = new Counter(10).inc.dec.inc.inc.count
  test is 12
  // 2.
  val test2 = new Counter(10).inc(5).dec.dec.dec.dec(2).inc.dec.dec(10).count
  test2 is 0
  // 3.
  val test3 = new Counter(10).inc.dec.inc(5).adjust(new Adder(5), 2).count
  test3 is 7
}