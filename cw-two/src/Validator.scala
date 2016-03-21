/**
  *
  */
trait Validator {

  def validateString(s: String, set: Set[Char], length: Int):Boolean

  def check(input: List[Char], code:List[Char]):String

}
