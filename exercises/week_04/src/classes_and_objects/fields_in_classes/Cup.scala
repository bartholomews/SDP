package classes_and_objects.fields_in_classes

import com.atomicscala.AtomicTest._

class Cup {
  var percentFull = 0
  val max = 100

  def add(increase: Int): Int = {
    percentFull += increase
    if (percentFull > max) {
      percentFull = max
    }
    // 2.
    if(percentFull < 0) {
      percentFull = 0
    }
    percentFull // Return this value
  }

  /**
    * 4.
    */
  def set(n: Int) {
    percentFull = n
  }

  def get(): Int = {
    percentFull
  }

}





