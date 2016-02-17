package aux_constructors

/**
  * Auxiliary Constructors
  */
class ClothesWasher(val modelName: String, val capacity: Double) {

  // 12.
  def this(modelName: String) {
    this(modelName, 2.5)  // 14.
  }

  // 12.
  def this(capacity: Double) {
    this("Bosch", capacity) // 14.
  }

  // 12.
  def this() {
    this("Bosch", 2.5)  // 14.
  }

}
