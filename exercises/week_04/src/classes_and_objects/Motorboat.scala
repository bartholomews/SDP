package classes_and_objects

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

    def signal(): String = {
      val flare = new Flare
      flare.light()
    }

}
