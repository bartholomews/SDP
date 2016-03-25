package pi

import akka.actor._


/*
Pi -> Master -> Listener
             ->

Not brute force, should recursively give work to actors which have finished
with their chunks: the dispatching part should be refactored to make it
work faster!

 */
object Pi extends App {

//  calculate(nrOfWorkers = 20, nrOfElements = 1000000, nrOfMessages = 1000000)
  calculate(nrOfWorkers = 4, nrOfElements = 1000, nrOfMessages = 10000)

  // TEST: resources/app.conf
  /*
  # Log level




   */

  // actors and messages ...

  def calculate(nrOfWorkers: Int, nrOfElements: Int, nrOfMessages: Int) {
    // Create an Akka system
    val system = ActorSystem("PiSystem")

    // create the result listener, which will print the result and shutdown the system
    val listener = system.actorOf(Props[Listener], name = "listener")

    // create the master
    /*
    Has to be created this way because it has parameters, instead of system.actorOf(Props[name])
     */
    val master = system.actorOf(Props(new Master(nrOfWorkers, nrOfMessages, nrOfElements, listener)),
      name = "master")

    // start the calculation
    master ! Calculate
  }
}