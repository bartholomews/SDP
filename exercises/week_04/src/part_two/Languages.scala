package part_two

import com.atomicscala.AtomicTest._

/**
  * 30.
  */
object Languages extends App {

  val s = Set("English", "French", "Spanish", "German", "Chinese")
  println(s.toString())
  s.size is 5

  // (a)
  val s2 = s | Set("Turkish") // can add new element ( '|' == 'union')
  println(s2.toString())
  s2.size is 6

  // (b)
  val s3 = s2 | Set("French") // cannot add duplicates, addition will just be ignored
  println(s3.toString())
  s3.size is 6

  // (c)
  val s4 = s3 -- Set("Spanish") // ('&~' == '--')
  println(s4.toString())
  s4.size is 5

  // (d)
  val m = Map(
    "jiminy@cricket.com" -> Name("Jiminy", "Cricket"),
    "mary@smith.com" -> Name("Mary", "Smith"),
    "sally@taylor.com" -> Name("Sally", "Taylor")
  )
  println(m.toString())
  m.size is 3
  val m2 = m.filterKeys((k) => k!="jiminy@cricket.com")
  println(m2.toString())
  m2.size is 2

}
