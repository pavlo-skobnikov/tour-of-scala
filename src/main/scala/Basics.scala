import scala.util.Random

/** Defining values.
  */
object DefineValue:
  val valNumInferred = 1 + 1
  val valNumWithExplicitType: Int = 1 + 1

/** Defining variables.
  */
object DefineVariables:
  var varStringInferred = "A variable."
  var varStringWithExplicitType: String = "A variable."

  // NOTE: Can be reassigned.
  varStringInferred = "A different value for a variable."

/**   - Combine >1 expressions with blocks.
  *   - Last expression is the return value.
  */
object Blocks:
  val bracketBlock: String = {
    val temporaryVariable = 5

    temporaryVariable.toString()
  }

  val indentationBlock: String =
    val temporaryVariable = 5

    temporaryVariable.toString()

/** Functions == expressions w/ >= 0 parameters.
  */
object Functions:
  val noArgsAnonymousFn = () => println("No number function called.")
  val singleArgAnonymousFn = (number: Int) =>
    println(s"Given number is $number")
  val multipleArgAnonymousFn = (firstArg: String, secondArg: String) =>
    println(
      s"The first argument is {$firstArg}, and the second one is {$secondArg}"
    )

/** Methods are functions defined with `def` with extra features.
  */
object Methods:
  def regularMethodDefinition(): Int = Random().nextInt()
  def noParameterListMethodDefinition: String = { Random().nextString(5) }
  def multipleParameterListsMethodDefinition(x: Int)(y: Int): Unit = print(
    s"The sum is ${x + y})"
  )

  // Multiple parameter lists are used for currying.
  val curried = multipleParameterListsMethodDefinition(3)
  curried(2) // => The sum is 5

/** Defining classes.
  */
object Classes:
  class CustomClass(innerValue: String):
    var innerVariable: String = null

    def printInner() = print(
      s"The class' value field is {$innerValue}, and the variable field is {$innerVariable}"
    )

  val instance = CustomClass("some value")
  instance.innerVariable = "updated value"

  instance.printInner() // => "some value" & "updated value"

  /* Compared by reference */
  val notEqualInstances: Boolean =
    CustomClass("") == CustomClass("") // => false

/** Defining case classes.
  */
object CaseClasses:
  case class DataClass(num: Int)

  /* Compared by values */
  val equalInstances: Boolean = DataClass(1) == DataClass(1) // => true

/** Defining objects.
  */
object Objects:
  object SingletonCounter:
    private var counter: Int = 0

    def count() =
      counter += 1

      print(s"The counter value is $counter")
  end SingletonCounter

  /* Objects can't be instantiated */
  // val instance = SingletonCounter()

  SingletonCounter.count() // => 1
  SingletonCounter.count() // => 2

/** Defining traits.
  */
object Traits:
  trait PhrasePrinter:
    def greet(subject: String) = print(s"Hello, $subject!")
    def sayAnything(): Unit

  class WhateverPrinter extends PhrasePrinter:
    override def greet(subject: String): Unit =
      super.greet(subject)
      sayAnything()

    override def sayAnything(): Unit = print("Whatever, man 🙄")

/** Defining a Scala program's entry point.
  */
object EntryPoint:
  // Runnable with `scala src/main/scala/Basics.scala` from the repository root.
  @main def helloWorldMain() = print("Hello, world!")
