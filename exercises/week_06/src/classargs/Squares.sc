// 5.

import com.atomicscala.AtomicTest._

def squareThem(n: Int*) = n.map(n => n * n).sum

squareThem(2) is 4
squareThem(2, 4) is 20
squareThem(1, 2, 4) is 21