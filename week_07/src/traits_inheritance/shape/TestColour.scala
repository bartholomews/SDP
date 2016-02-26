package traits_inheritance.shape

import com.atomicscala.AtomicTest._

object TestColour extends App {

  Colour.newColour("Dark Slate Blue", 72, 61, 139).Dark() is true

}
