import com.atomicscala.AtomicTest._

// Vectors

// 1.

val v1 = Vector(1, 2, 3)
val v2 = Vector('A', 'B', 'C')
val v3 = Vector("A", "B", "C")
val v4 = Vector(1.0, 2.0, 3.0)
val v5 = Vector(true, false)

// 2.

val v6 = Vector(v1, v2, v3, v4, v5)

// 3.

val words: Vector[String] = Vector("The", "dog", "visited", "the", "fire", "station")

val sentence = words.mkString(" ").concat(" ")

sentence.toString is "The dog visited the fire station "

// 4.

val vI = Vector(1, 2, 3)
val vD = Vector(1.0, 2.0, 3.0)

vI.sum
vI.min
vI.max

vD.sum
vD.min
vD.max

// 5.

val myVector1 = Vector(1, 2, 3, 4, 5, 6)
val myVector2 = Vector(1, 2, 3, 4, 5, 6)

myVector1 is myVector2

