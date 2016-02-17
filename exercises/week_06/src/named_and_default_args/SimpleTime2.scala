package named_and_default_args

/**
  * Named & Default Arguments
  */

// 7.
class SimpleTime2(val hours: Int, val minutes: Int) {

  def this(hours: Int) {
    this(hours, 0)
  }

}
