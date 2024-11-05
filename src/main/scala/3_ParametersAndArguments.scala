object DefaultParameters:
  def hello(thing: String = "World") = s"Hello, $thing"

  List(
    hello(),
    hello("Jupiter")
  ).foreach(println(_))

  // Not allowed => the compiler can't know what to call.
  // def overloaded(number: Int = 0): Unit = ???
  // def overloaded(string: String = 0): Unit = ???
end DefaultParameters

object DefaultArguments:
  def printFullName(first: String, middle: String = "Q.", last: String): Unit =
    println(s"$first $middle $last")

    printFullName(first = "John", last = "Public")
    // => Prints "John Q. Public"
    printFullName("John", last = "Public")
    // => Prints "John Q. Public"
    printFullName("John", middle = "Quincy", "Public")
    // => Prints "John Quincy Public"
    printFullName(last = "Public", first = "John")
    // => Prints "John Q. Public"
    // printFullName(last = "Public", "John" )
    // => ERROR: positional after named argument
  end printFullName
end DefaultArguments
