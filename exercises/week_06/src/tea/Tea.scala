package tea

/**
  * Constructors
  */

// 11.
class Tea(name: String = "Earl Grey", milk: Boolean = false, sugar: Boolean = false, decaf: Boolean = false) {

  def describe = {
    var desc = name
    if(decaf) desc += " decaf"
    if(milk) desc += " + milk"
    if(sugar) desc += " + sugar"
    desc
  }

  def calories = {
    var n = 0
    if(milk) n+= 100
    if(sugar) n+= 16
    n
  }

}
