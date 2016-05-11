//=========================================================================================================

// 1. What are the values and types of the following Scala literals?

42 // Int = 42
true  // Boolean = true
123L  // Long = 123
42.0  // Double = 42.0
//=========================================================================================================

// 2. What is the difference between the following literals?

'a' // this is a literal of type Char with value = a
"a" // this is a literal of type String with value = a
//=========================================================================================================

// 3. What is the difference between the following expressions?
"Hello world!"  // this is a literal of type String and value = Hello world!
println("Hello world!") // this is an expression which returns a type Unit holding the String Hello World!
//=========================================================================================================

/* 4. What is the type and value of the following literal?
 */
// 'Hello world!' // This literal does not compile: the single quote is expecting a Char
//=========================================================================================================

// 5. What are the types and values of the following conditionals?
// http://www.scala-lang.org/files/archive/spec/2.11/06-expressions.html#numeric-widening

val a = 1   // String = predator
val b = 2
if(a > b) "alien" else "predator"

val a2 = 1  // Any = 2001
val b2 = 2
if (a2 > b2) "alien" else 2001

if(true) "hello"  // Any = "hello"
//=========================================================================================================

// 6. What is the difference between the following expressions?
//    What are the similarities?

1 + 2 + 3 // This is an expression, equal to (1).+(2).+(3)
6   // This is a value
// Both evaluate to the Int value 6
//=========================================================================================================

/* 7. Define an object called cal with a method square that accepts a Double
      as an argument and... you guessed it... squares its input.
      Add a method called cube that cubes its input and calls square
      as part of its result calculation.
*/

object calc {
  def square(n: Double): Double = {
    n * n
  }

  def cube(n: Double) : Double = {
    square(n) * n
  }
}
//=========================================================================================================

/* 8. Copy and paste calc from the previous exercise to create a calc2
      that is generalised to work with Ints as well as Doubles.
      As you have Java experience, this should be fairly straightforward.
 */

object calc2 {

  def square[T](x: T)(implicit num: Numeric[T]): T = {
    import num._
    x * x
  }

  def cube[T](x: T)(implicit num: Numeric[T]): T = {
    import num._
    square(x) * x
  }

}
  //=========================================================================================================

  /* 9. When entered on the REPL, what does the following program output,
      and what is the type and value of the final expression?
 */

  object argh {
    def a = {
      println("a")
      1
    }

    val b = {
   //   println("b")
      a + 2
    }

    def c = {
      println("c")
      a
      b + "c"
    }
  }

println("================================")

argh.c + argh.b + argh.a

/*
a: Int (def which evaluates to 1)
b: Int = 3 (val)
c: String (def which evaluates to "3c")

an expression concatenating (c + b + a) has value "3c31"

and it outputs:
c
a
a
(println from val gets executed when declared)
*/

//=========================================================================================================