import zio.test.Assertion._
import zio.test.{DefaultRunnableSpec, suite, _}
object ZioMagicTest extends DefaultRunnableSpec {
  case class Person(name: String, age: Int)

  val sut = List(1, 2, 3, 4, 5, 6, 7).map(i => Person(i.toString, i))

  val test1 = test("doesn't work without helping type inference at the forall-combinator") {
    assert(sut)(forall[Person](hasField("age", _.age, isWithin(1, 6))) && hasSize(equalTo(8)))
  }

  override val spec = suite("ZioMagic")(test1)
}
