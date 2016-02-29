/**
  *
  */
class ValidatorImpl extends Validator {

  override def validateString(s: String, set: Set[Char], length: Int): Boolean = {
    if(s.length != length) false
    else s.forall(c => set.contains(c))
  }

}
