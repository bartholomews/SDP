package further_scala

import com.atomicscala.AtomicTest._

/**
  * 1.
  */
class Counter(val count: Int) {
  // 1.
  def inc = new Counter(count + 1)
  def dec = new Counter(count - 1)
  // 2.
  def inc(i: Int = 1) = new Counter(count + i)
  def dec(d: Int = 1) = new Counter(count - d)
  // 3.
  def adjust(a: Adder, i: Int) = new Counter(a.add(i))
}

// 9.
case class CounterCC(count: Int = 0) {
  def inc = copy(count + 1)
  def dec = copy(count -1)
  def inc(i: Int = 1) = copy(count + i)
  def dec(i: Int = 1) = copy(count - i)
  def adjust(a: Adder, i: Int) = copy(a.add(i))
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

  // 9.
  val test4 = new CounterCC(10).inc.dec.inc.inc.count
  test4 is 12
  val test5 = new CounterCC(10).inc(5).dec.dec.dec.dec(2).inc.dec.dec(10).count
  test5 is 0
  val test6 = new CounterCC(10).inc.dec.inc(5).adjust(new Adder(5), 2).count
  test6 is 7

}