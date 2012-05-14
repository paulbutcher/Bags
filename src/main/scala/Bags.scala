object Bags {
  
  type Bag = Set[String]

  def consolidate(bs: List[Bag]): List[Bag] = bs match {
    case h :: t => consolidate(h, consolidate(t))
    case Nil => Nil
  }
  
  // Assumes that bs has already been consolidated
  def consolidate(b: Bag, bs: List[Bag]): List[Bag] = bs.foldLeft(List(b)) { (x, y) =>
    val h :: t = x
    if ((h intersect y).nonEmpty)
      (h ++ y) :: t
    else
      x :+ y
  }
}