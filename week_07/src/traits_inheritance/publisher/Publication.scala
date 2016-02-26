package traits_inheritance.publisher

/**
  * Traits and Inheritance
  * (7.)
  */
sealed trait Publication

case class Book(author: Author) extends Publication

case class Periodical(editor: Editor, issue: Issue*) extends Publication