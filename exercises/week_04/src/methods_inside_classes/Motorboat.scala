package methods_inside_classes

/**
  * 1. Methods inside Classes
  */
class Motorboat {

    def on(): String = {
      "Motor on"
    }

    def off(): String = {
      "Motor off"
    }

    // 3.
    def signal(): String = {
      val flare = new Flare
      flare.light()
    }

}
