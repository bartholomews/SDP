package classargs

/**
  * Created by mba13 on 17/02/2016.
  */

// 4.
class FlexibleFamily (father: String, mother: String, children: String*) {

  // 4.
  def familySize() = children.length + 2

}
