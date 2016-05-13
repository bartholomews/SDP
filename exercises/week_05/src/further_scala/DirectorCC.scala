package further_scala

import com.atomicscala.AtomicTest._

/**
  * 8.
  */
case class DirectorCC(firstName: String, lastName: String, yearOfBirth: Int) {
  def name = firstName + " " + lastName
  def older(d1: Director, d2: Director) = if(d1.yearOfBirth > d2.yearOfBirth) d1 else d2
}

case class FilmCC(name: String, yearOfRelease: Int, imdbRating: Double, director: DirectorCC) {
  def directorAge = yearOfRelease - director.yearOfBirth
  def isDirectedBy(director: DirectorCC): Boolean = this.director == director
  def copy(name: String = name, yearOfRelease: Int = yearOfRelease,
           imdbRating: Double = imdbRating, director: DirectorCC = director) =
    new FilmCC(name, yearOfRelease, imdbRating, director)
  def highestRating(f1: Film, f2: Film) = if(f1.imdbRating > f2.imdbRating) f1 else f2
  def oldestDirectorAtTheTime(f1: Film, f2: Film) = {
    if(f1.directorAge > f2.directorAge) f1.director else f2.director
  }
}

object FilmTestCC extends App {
  val eastwood = new DirectorCC("Clint", "Eastwood", 1930)
  val mcTiernan = new DirectorCC("John", "McTiernan", 1951)
  val nolan = new DirectorCC("Christopher", "Nolan", 1970)
  val someGuy = new DirectorCC("Just", "Some Guy", 1990)

  val memento = new FilmCC("Memento", 2000, 8.5, nolan)
  val darkKnight = new FilmCC("Dark Knight", 2008, 9.0, nolan)
  val inception = new FilmCC("Inception", 2010, 8.8, nolan)

  val highPlainsDrifter = new FilmCC("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales = new FilmCC("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven = new FilmCC("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new FilmCC("Gran Torino", 2008, 8.2, eastwood)
  val invictus = new FilmCC("Invictus", 2009, 7.4, eastwood)

  val predator = new FilmCC("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new FilmCC("Die Hard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = new FilmCC("The Hunt for Red October", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = new FilmCC("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

  eastwood.yearOfBirth is 1930 // should be 1930
  dieHard.director.name is "John McTiernan" // should be "John McTiernan"
  invictus.isDirectedBy(nolan) is false // should be false
  predator.isDirectedBy(mcTiernan) is true

  highPlainsDrifter.copy(name = "L'homme des hautes plaines").imdbRating is 7.7
  thomasCrownAffair.copy(yearOfRelease = 1968, director =
    new DirectorCC("Norman", "Jewison", 1926)).director.yearOfBirth is 1926
  inception.copy().copy().copy().isDirectedBy(nolan)
}