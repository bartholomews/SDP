object Factory {
  def getInstance(c: Class[_], b: Boolean): Game = {
    new GameNewImpl(b, 12)
  }
  def getInstance(c: Class[_], b: Boolean, guesses: Int): Game = {
    new GameNewImpl(b, guesses)
  }
}