package classargs

/**
  * Class Arguments
  */

// 4.
class FlexibleFamily (father: String, mother: String, children: String*) {

  // 4.
  def familySize() = children.length + 2

}
