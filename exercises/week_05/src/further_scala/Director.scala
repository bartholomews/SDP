package further_scala

import com.atomicscala.AtomicTest._

/**
  * 5.
  */
class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {
  def name = firstName + " " + lastName
}

// 6.
object Director {
  def apply(firstName: String, lastName: String, yearOfBirth: Int) =
    new Director(firstName, lastName, yearOfBirth)
  def older(d1: Director, d2: Director) = if(d1.yearOfBirth > d2.yearOfBirth) d1 else d2
}

class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {
  def directorAge = yearOfRelease - director.yearOfBirth
  def isDirectedBy(director: Director): Boolean = this.director == director
  def copy(name: String = name, yearOfRelease: Int = yearOfRelease,
           imdbRating: Double = imdbRating, director: Director = director) =
    new Film(name, yearOfRelease, imdbRating, director)
}

// 6.
object Film {
  def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) = {
    new Film(name, yearOfRelease, imdbRating, director)
  }
  def highestRating(f1: Film, f2: Film) = if(f1.imdbRating > f2.imdbRating) f1 else f2
  def oldestDirectorAtTheTime(f1: Film, f2: Film) = {
    if(f1.directorAge > f2.directorAge) f1.director else f2.director
  }
}


object FilmTest extends App {
  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan = new Director("John", "McTiernan", 1951)
  val nolan = new Director("Christopher", "Nolan", 1970)
  val someGuy = new Director("Just", "Some Guy", 1990)

  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)

  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus = new Film("Invictus", 2009, 7.4, eastwood)

  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

  eastwood.yearOfBirth is 1930 // should be 1930
  dieHard.director.name is "John McTiernan" // should be "John McTiernan"
  invictus.isDirectedBy(nolan) is false // should be false
  predator.isDirectedBy(mcTiernan) is true

  highPlainsDrifter.copy(name = "L'homme des hautes plaines").imdbRating is 7.7
  thomasCrownAffair.copy(yearOfRelease = 1968, director = new Director("Norman", "Jewison", 1926)).director.yearOfBirth is 1926
  inception.copy().copy().copy().isDirectedBy(nolan)
}

/* 7.

Type or Value?
In each case identify whether the word Film refers to the type or value:

(a) val prestige: Film = bestFilmByChristopherNolan()
TYPE

(b) new Film("Last Action Hero", 1993, mcTiernan)
TYPE

(c) Film("Last Action Hero", 1993, mcTiernan)
VALUE

(d) Film.newer(highPlainsDrifter, thomasCrownAffair)
VALUE

(e) Film.type
VALUE

 */
