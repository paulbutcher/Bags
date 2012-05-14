import org.scalatest.Suite

class BagsTest extends Suite {
  
  import Bags._
  
  val b_a = Set("a")
  val b_b = Set("b")
  val b_c = Set("c")
  val b_ab = Set("a", "b")
  val b_cd = Set("c", "d")

  def testBags {
    assert(consolidate(List()) === List())
    assert(consolidate(List(b_a, b_b)) === List(b_a, b_b))
    assert(consolidate(List(b_a, b_b, b_c)) === List(b_a, b_b, b_c))
    assert(consolidate(List(b_a, b_b, b_ab)) === List(b_ab))
    assert(consolidate(List(b_ab, b_a, b_b)) === List(b_ab))
    assert(consolidate(List(b_ab, b_a, b_b, b_c)) === List(b_ab, b_c))
    assert(consolidate(List(b_ab, b_a, b_b, b_cd)) === List(b_ab, b_cd))
    assert(consolidate(List(b_ab, b_a, b_b, b_cd, b_c)) === List(b_ab, b_cd))
  }
}