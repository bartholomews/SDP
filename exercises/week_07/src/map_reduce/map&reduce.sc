import com.atomicscala.AtomicTest._

// map & reduce

// 1.---------------------------------------------------------------------

// (a)

val v = Vector(1, 2, 3, 4)
v.map(n => n + 1) is Vector(2, 3, 4, 5)
v.map(n => n * 11 + 10) is Vector(21, 32, 43, 54)
/* (b)
can't replace foreach() with map(), as
foreach() works on each value and returns Unit,
while we need to transform the Vector:
map() returns a new Vector with values transformed
as per function
*/
// v.foreach(n => n * 11 + 10) is Vector(21, 32, 43, 54)

/* (c)
map approach is less complex, more concise and
less prone to errors than the for loop approach
*/

(for (i <- v) yield i * 11 + 10) is Vector(21, 32, 43, 54)

// 2.---------------------------------------------------------------------
v.map(n => n + 1) is Vector(2, 3, 4, 5)
(for(i <- v) yield i + 1) is Vector(2, 3, 4, 5)

// 3.---------------------------------------------------------------------
// Reduce.scala
val r = Vector(1, 10, 100, 1000)
r.reduce((sum, n) => sum + n) is 1111

var r2: Int = 0
for(n <- r) r2 += n
r2 is 1111

// 4.---------------------------------------------------------------------

def sumIt(n: Int*):Int = {
    n.reduce((sum, n) => sum + n)
}

sumIt(1, 2, 3) is 6
sumIt(45, 45, 45, 60) is 195