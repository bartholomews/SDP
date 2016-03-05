package tea

/**
  * Constructors
  */

// 11.
class Tea(name: String = "Earl Grey", milk: Boolean = false, sugar: Boolean = false, decaf: Boolean = false) {

  def describe = {
    def isDecaf = if (decaf) "decaf" else ""
    def hasMilk = if (milk) "milk" else ""
    def hasSugar = if (sugar) "sugar" else ""
    List(name, isDecaf, hasMilk, hasSugar).mkString(" ")
  }

  def calories = {
    def getMilk = if (milk) 100 else 0
    def getSugar = if (sugar) 16 else 0
    getMilk + getSugar
  }

}
