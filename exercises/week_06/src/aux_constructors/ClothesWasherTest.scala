package aux_constructors

import com.atomicscala.AtomicTest._

/**
  * Auxiliary Constructors
  */

object ClothesWasherTest extends App {

  // 12. ---------------------------------------------------------------

  val test1a = new ClothesWasher
  test1a.modelName is "Bosch"
  test1a.capacity is 2.5

  val test2a = new ClothesWasher(modelName = "Bush")
  test2a.modelName is "Bush"
  test2a.capacity is 2.5

  val test3a = new ClothesWasher(capacity = 3.0)
  test3a.modelName is "Bosch"
  test3a.capacity is 3

  val test4a = new ClothesWasher(modelName = "Bush", capacity = 3)
  test4a.modelName is "Bush"
  test4a.capacity is 3.0

  // 13. ---------------------------------------------------------------

  val test1b = new ClothesWasher2
  test1b.modelName is "Bosch"
  test1b.capacity is 2.5

  val test2b = new ClothesWasher2(modelName = "Bush")
  test2b.modelName is "Bush"
  test2b.capacity is 2.5

  val test3b = new ClothesWasher2(capacity = 3.0)
  test3b.modelName is "Bosch"
  test3b.capacity is 3

  val test4b = new ClothesWasher2(modelName = "Bush", capacity = 3)
  test4b.modelName is "Bush"
  test4b.capacity is 3.0

}
