import com.atomicscala.AtomicTest._

//=========================================================================================================

// 13.

val range1 = Range(0, 10)
val r1 = 10
r1 is range1.end
val range2 = Range.inclusive(0,10)
r1 is range2.end

/*
both tests passed: Range.end
does not define the last element
of the object, just the second
argument passed when instantiated.
 */

//=========================================================================================================

// 14.

val zeroToTen = Range.inclusive(0, 10)
var result = 0
for(i <- zeroToTen.indices) {
  result = result + i
}
result is 55

// a 'var' is necessary in order to
// accumulate the partial results
// while iterating

//=========================================================================================================

// 15.

result = 0

// with step
// val evens = Range.inclusive(2, 10, 2)

// with modulo conditional
val totalEvens = {
  for(i <- 1 to 10) {
    if(i % 2 == 0) {
      result = result + i
    }
  }
  result
}

totalEvens is 30

//=========================================================================================================

// 16.

var evens = 0
var odds = 0
for (i <- 0 to 10) {
  if (i % 2 == 0) {
    evens = evens + i
  } else {
    odds = odds + i
  }
}

evens is 30

//=========================================================================================================

// 17.

val v = Vector("The", "dog", "visited", "the", "firehouse")
var sentence = ""
for(i <- v.iterator) {
  println(i)
  sentence = sentence + i + " "
}

sentence is "The dog visited the firehouse "

//=========================================================================================================

// 18.

var reversed: String = ""
for (i <- v.iterator) {
  val aux = i.reverse
  println(aux)
  reversed = reversed + aux + " "
}

reversed is "ehT god detisiv eht esuoherif "

//=========================================================================================================

// 19.

var reverseOrder: String = ""
for(i <- v.reverseIterator) {
  println(i)
  reverseOrder = reverseOrder + i + " "
}

reverseOrder is "firehouse the visited dog The "

//=========================================================================================================

// 20.

val v1: Vector[Int] = Vector(1, 2, 3, 4, 5)
val v2: Vector[Double] = Vector(1.5, 2.5, 3.5)

// (a)

v1.sum
v2.sum
v1.min
v2.min
v1.max
v2.max

// (b)

val v3: Vector[String] = Vector("A", "B", "C")

// "sum" takes implicit parameter Numeric[B]
// String is not a subtype of Numeric,
// so the compiler cannot provide a String
// as implicit argument
// v3.sum

// "min" and "max" take implicit Ordering[B]
// trait which defines subtypes of AnyVal (e.g. Int, Double),
// String and many others
// see http://www.scala-lang.org/api/current/#scala.math.Ordering
v3.min
v3.max

// (c)

val r = Range(1, 10)
r.sum // entire summation in "one step"

//=========================================================================================================

// 21.

val l = List("The", "dog", "visited", "the", "firehouse")

l.sum
l.min
l.max
l.foreach(word => println(word))
l.foreach(word => println(word.reverse))
l.foreach(word => println(word.sorted))

val s = Set ("The", "dog", "visited", "the", "firehouse")

s.sum
s.min
s.max
s.foreach(word => println(word))
s.foreach(word => println(word.reverse))
s.foreach(word => println(word.sorted))

//=========================================================================================================

// 22.

def isPalindrome(s: String) = s == s.reverse

isPalindrome("mum") is true
isPalindrome("dad") is true
isPalindrome("street") is false

//=========================================================================================================

// 23.

def forecast(celsius: Int) = celsius match {
  case 100 => "Sunny"
  case 80 => "Mostly Sunny"
  case 50 => "Partly Sunny"
  case 20 => "Mostly Cloudy"
  case 0 => "Cloudy"
  case _ => "Unknown"
}

forecast(100) is "Sunny"
forecast(80) is "Mostly Sunny"
forecast(50) is "Partly Sunny"
forecast(20) is "Mostly Cloudy"
forecast(0) is "Cloudy"
forecast(15) is "Unknown"

//=========================================================================================================