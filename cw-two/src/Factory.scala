object Factory {
  def getInstance(c: Class[_], b: Boolean): Game = {
    new GameNewImpl(b)
  }
}