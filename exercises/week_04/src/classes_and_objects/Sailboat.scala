package classes_and_objects

/**
  * 1. Methods inside Classes
  */
class Sailboat {

  def raise(): String = {
    val s = "Sails raised"
    println(s)
    s
  }

  def lower(): String = {
    val s = "Sails lowered"
    println(s)
    s
  }

  def signal(): String = {
    val flare = new Flare
    flare.light()
  }

}
