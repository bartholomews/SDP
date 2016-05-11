package part_two

import com.atomicscala.AtomicTest._

/**
  * 26.
  */
class Planet(val name: String, val description: String, val moons: Int = 1) {
  def hasMoon = moons != 0
}

object TestPlanet extends App {
  val p = new Planet(name = "Mercury", description = "small and hot planet", moons = 0)
  p.hasMoon is false
}