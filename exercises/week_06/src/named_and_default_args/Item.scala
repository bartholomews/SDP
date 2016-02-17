package named_and_default_args

/**
  * Named & Default Arguments
  */

// 10.
class Item(name: String, price: Double) {

  def cost(grocery: Boolean = false, medication: Boolean = false, rate: Double = 0.10): Double = {
    if(grocery || medication) price
    else price + price * rate
  }
}
