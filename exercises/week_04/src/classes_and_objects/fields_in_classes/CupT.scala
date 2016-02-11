package classes_and_objects.fields_in_classes

import com.atomicscala.AtomicTest._

object CupT extends App {

  /**
    * 1. No additional code to satisfy these tests:
    * the method decrease the total if its parameter
    * is negative, going below zero in case;
    */
  val cup = new Cup
  cup.add(45) is 45
  cup.add(-15) is 30
  //  cup.add(-50) is -20

  cup.percentFull = 0

  /**
    * 2.
    */
  cup.add(45) is 45
  cup.add(-55) is 0
  cup.add(10) is 10
  cup.add(-9) is 1
  cup.add(-2) is 0

  /**
    * 3. percentFull can be set from outside the class;
    */
  cup.percentFull = 56
  cup.percentFull is 56

  /**
    * 4.
    */
  val cup2 = new Cup()
  cup2.set(56)
  cup2.get() is 56

}
