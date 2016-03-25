package pi

import scala.concurrent.duration._

sealed trait PiMessage

// kick off
case object Calculate extends PiMessage

// work on a chunk, from start working with n elements
case class Work(start: Int, nrOfElements: Int) extends PiMessage

// each worker send back the Result of what computed
case class Result(value: Double) extends PiMessage

// combine the chunks and calculate computation time
case class PiApproximation(pi: Double, duration: Duration)