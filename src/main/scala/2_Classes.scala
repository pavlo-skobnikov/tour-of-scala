object DefiningClasses:
  class User

  val aUser = User()

  class Point(var x: Int = 0, var y: Int = 0):

    def move(dx: Int, dy: Int) =
      x = dx + x
      y = dy + y

    override def toString(): String = s"($x, $y)"
  end Point

  object PointPlayground:
    val pointWithCustomArgs = Point(1, 1)

    println(pointWithCustomArgs)

    pointWithCustomArgs.move(-10, 5)

    println(pointWithCustomArgs)

    val pointWithDefaultArgs = Point()

    print(pointWithDefaultArgs)
  end PointPlayground
end DefiningClasses

object PrivateMemberAndGettersSetters:
  class NonNegativeNumber private ():
    private val lowerBound = 0
    private var _value = 0

    def value: Int = _value
    @throws[IllegalArgumentException]
    def value_=(newValue: Int): Unit =
      if isValueValid(newValue)
      then _value = newValue
      else throw IllegalArgumentException(s"$value isn't valid!")

    def isValueValid(value: Int): Boolean = value > lowerBound

  end NonNegativeNumber

  object NonNegativeNumber:
    def apply(value: Int): NonNegativeNumber =
      val number = new NonNegativeNumber

      number.value = value

      number
    end apply
  end NonNegativeNumber

  val nonNegative = NonNegativeNumber(0)

  nonNegative.value = 3
end PrivateMemberAndGettersSetters
