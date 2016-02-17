package named_and_default_args

import com.atomicscala.AtomicTest._

/**
  * Named & Default Arguments
  */

// 8.
object PlanetTest extends App {

  // 8.
  val p = new Planet(name = "Mercury",
    description = "small and hot planet", moons = 0)
  p.hasMoon is false

  // 9. No need to change any code: "named arguments" specifies the arguments
  // based on the parameter names, not on position
  val earth = new Planet(moons = 1, name = "Earth",
    description = "a hospitable planet")
  earth.hasMoon is true

}
