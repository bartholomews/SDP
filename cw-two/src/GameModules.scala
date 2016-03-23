/**
  *
  */

import com.softwaremill.macwire._

/*
trait GameModules {
  def colours: Colours
  def shuffler: Shuffler
  def validator: Validator
  def board: Board
}
*/

  class GameModules() {
    lazy val colours = wire[ColoursImpl]
  //  lazy val shuffler = (length: Int) => wire[ShufflerImpl]
    lazy val shuffler = wire[ShufflerImpl]
    lazy val validator = wire[ValidatorImpl]
    lazy val board = (rows: Int) => wire[BoardImpl]
  }