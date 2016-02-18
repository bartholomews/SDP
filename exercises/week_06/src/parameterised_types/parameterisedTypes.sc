import com.atomicscala.AtomicTest._

// Parameterised Types

// 17.---------------------------------------------------------------------

// Return type is inferred:
def inferred(c1: Char, c2: Char, c3: Char) = {
  Vector(c1, c2, c3)
}
// Explicit return type:
def explicit(c1: Char, c2: Char, c3: Char): Vector[Char] = {
  Vector(c1, c2, c3)
}
inferred('a', 'b', 'c') is "Vector(a, b, c)"
explicit('a', 'b', 'c') is "Vector(a, b, c)"

def explicitDouble(d1: Double, d2: Double, d3: Double): Vector[Double] = {
  Vector(d1, d2, d3)
}

explicitDouble(1.0, 2.0, 3.0) is "Vector(1.0, 2.0, 3.0)"

// 18.---------------------------------------------------------------------
def explicitList(vector: Vector[Double]): List[Double] = {
  vector.toList
}

explicitList(Vector(10.0, 20.0)) is List(10.0, 20.0)
explicitList(Vector(1, 2, 3)) is List(1.0, 2.0, 3.0)

// 19.---------------------------------------------------------------------
def explicitSet[A](vector: Vector[A]):Set[A] = {
  vector.toSet
}
explicitSet(Vector(10.0, 20.0, 10.0)) is Set(10.0, 20.0)
explicitSet(Vector(1, 2, 3, 2, 3, 4)) is Set(1.0, 2.0, 3.0, 4.0)

// Functions as Objects

// 20.---------------------------------------------------------------------
val str: String = explicitSet(Vector(1, 2, 3, 4)).mkString(",").concat(",")
println(str)
str is "1,2,3,4,"

// 21.---------------------------------------------------------------------
val dogYears = { n: Int => n * 7 }
dogYears(10) is 70

// 22.---------------------------------------------------------------------
var s = ""
val v = Vector(1, 5, 7, 8)
v.foreach(n => s += dogYears(n) + " ")
s is "7 35 49 56 "

// 23.---------------------------------------------------------------------
s = ""
val numbers = Vector(1, 2, 5, 3, 7)
numbers.foreach(n => s += n * n + " ")
s is "1 4 25 9 49 "

// ------------------------------------------------------------------------
