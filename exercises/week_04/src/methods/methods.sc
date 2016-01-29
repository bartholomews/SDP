
// Methods

// 1.

def getSquare(x: Int): Int = {
  x * x
}

val a = getSquare(3)
assert(a == 9, a + "!= 9")

val b = getSquare(6)
assert(b == 36, b + "!= 36")

val c = getSquare(5)
assert(c == 25, c + "!= 25")

// 2.

def isArg1GreaterThanArg2(arg1: Double, arg2: Double): Boolean = {
  arg1 > arg2
}

val t1 = isArg1GreaterThanArg2(4.1, 4.12)
assert(!t1)

val t2 = isArg1GreaterThanArg2(2.1, 1.2)
assert(t2)

// 3.

def manyTimesString(s: String, n: Int): String = {
  if(n<=0) ""
  else if(n==1) s
  else s.concat(manyTimesString(s, n-1))
}

val m1 = manyTimesString("abc", 3)
assert("abcabcabc" == m1, m1 + " != abcabcabc")

val m2 = manyTimesString("123", 2)
assert("123123" == m2, m2 + " != 123123")

