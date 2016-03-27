package pi

import akka.actor.{Actor, ActorRef, Props}
import akka.routing.RoundRobinPool

import scala.concurrent.duration._


class Master(nrOfWorkers: Int, nrOfMessages: Int, nrOfElements: Int, listener: ActorRef)
  extends Actor {

  var pi: Double = _
  var nrOfResults: Int = _
  val start: Long = System.currentTimeMillis

  /*
  Create working Actors with a Router: the RoundRobinPool (or Group)

   */
  val workerRouter = context.actorOf(
    Props[Worker].withRouter(RoundRobinPool(nrOfWorkers)), name = "workerRouter")

  //  var router = {
  //    val routees = Vector.fill(5) {
  //      val r = context.actorOf(Props[Worker])
  //      context watch r
  //      ActorRefRoutee(r)
  //    }
  //    Router(RoundRobinRoutingLogic(), routees)
  //  }

  def receive = {

     // from Pi message to kick off
    case Calculate ⇒                        // from 0 to number of elements: chunk next chunk.. etc.
      for (i ← 0 until nrOfMessages) workerRouter ! Work(i * nrOfElements, nrOfElements)

      // when Workers have finished return Result
    case Result(value) ⇒
      pi += value
      nrOfResults += 1
      if (nrOfResults == nrOfMessages) {  // all messages are retrieved
        // Send the result to the listener
        listener ! PiApproximation(pi, duration = (System.currentTimeMillis - start) millis)
        // Stops this actor and all its supervised children
        context stop self
      }
  }

}