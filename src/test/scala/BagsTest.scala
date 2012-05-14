import org.scalatest.Suite

class BagsTest extends Suite {
  
  import Bags._
  
  val a = Set("a")
  val b = Set("b")
  val c = Set("c")
  val ab = Set("a", "b")
  val bc = Set("b", "c")
  val cd = Set("c", "d")
  val da = Set("d", "a")
  val ef = Set("e", "f")
  val fg = Set("f", "g")
  val gh = Set("g", "h")
  val ha = Set("h", "a")
  val abc = Set("a", "b", "c")
  val abcd = Set("a", "b", "c", "d")
  val abcdefgh = Set("a", "b", "c", "d", "e", "f", "g", "h")

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
	assert(consolidate(List(ab, bc, cd, da)) === List(abcd))
	assert(consolidate(List(ab, bc, cd, da, ef, fg, gh, ha)) === List(abcdefgh))
  }
}