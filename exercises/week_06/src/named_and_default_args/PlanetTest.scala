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

}
