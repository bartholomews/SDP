import com.atomicscala.AtomicTest._

/*
  1. Write a product function that calculates
  the product of the values of a function
  for the points on a given interval.
 */

def prod(f: Int => Int, a: Int, b: Int): Int = {
  if(a > b) 1
  else f(a) * prod(f, a+1, b)
}

prod(x => x * x, 2, 3) is 36
prod(x => x + x, 1, 2) is 8

/*
  2. Write factorial in terms of product.
 */

def fact(x: Int): Int = {
  if(x == 0) 0
  else prod(x => x, 1, x)
}

fact(0) is 0
fact(1) is 1
fact(2) is 2
fact(3) is 6
fact(4) is 24

/*
  3. Can you write a more general function,
  which generalizes both sum and product?
 */

def funk(f: (Int, Int) => Int, a: Int, b: Int): Int = {
  f(a, b)
}