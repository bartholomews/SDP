package named_and_default_args

/**
  * Named & Default Arguments
  */

// 8.
class Planet(val name: String, val description: String, val moons: Int) {

  // 8.
  def this(name: String, description: String) {
    this(name, description, 1)
  }

  // 8.
  def hasMoon = moons > 0

}
