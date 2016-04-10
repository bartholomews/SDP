/**
  * Trait Result can be a class 'Won' or 'NotWon',
  * each with a String message
  *
  * @author annabel.jump, federico.bartolomei
  */

sealed trait Result {
  val hasWon: Boolean
  val message: String
}

final case class Won(message: String) extends Result {
  override val hasWon = true
}

final case class NotWon(message: String) extends Result {
  override val hasWon = false
}

