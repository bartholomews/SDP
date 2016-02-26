package traits_inheritance.publisher

/**
  * Traits and Inheritance
  * (7.)
  */
class Issue(vol: Volume, n: Number, e: Editor, manuscripts: Seq[Manuscript]) extends Periodical(e)
