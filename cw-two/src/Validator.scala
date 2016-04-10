/**
  * Trait for functions to validate inputs as per Mastermind functionality.
  *
  * @author annabel.jump, federico.bartolomei
  */
trait Validator {
  /**
    * Validate an user input String against a set of Chars, as per Mastermind rules.
    *
    * @param input the input String to be validated
    * @param set the set of Chars against which the input will be validated
    * @param length the length
    * @return true il the input String is valid, false otherwise
    */
  def validateString(input: String, set: Set[Char], length: Int): Boolean

  /**
    * Validate an user input against the code, as per Mastermind rules.
    * Should return a `Result` with either a Won or NotWon boolean value
    * and a result String message.
    *
    * @param input the input to be checked
    * @param code the code against which the input will be checked
    * @return a {@see Result}
    */
  def check(input: List[Char], code: List[Char]): Result
}
