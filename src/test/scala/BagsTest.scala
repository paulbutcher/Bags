import org.scalatest.Suite

class BagsTest extends Suite {
  
  import Bags._
  
  val a = Set("a")
  val b = Set("b")
  val c = Set("c")
  val ab = Set("a", "b")
  val cd = Set("c", "d")
  val bc = Set("b", "c")
  val abc = Set("a", "b", "c")

  def testBags {
    assert(consolidate(List()) === List())
    assert(consolidate(List(a, b)) === List(a, b))
    assert(consolidate(List(a, b, c)) === List(a, b, c))
    assert(consolidate(List(a, b, ab)) === List(ab))
    assert(consolidate(List(ab, a, b)) === List(ab))
    assert(consolidate(List(ab, a, b, c)) === List(ab, c))
    assert(consolidate(List(ab, a, b, cd)) === List(ab, cd))
    assert(consolidate(List(ab, a, b, cd, c)) === List(ab, cd))
    assert(consolidate(List(ab, bc)) === List(abc))
  }
}