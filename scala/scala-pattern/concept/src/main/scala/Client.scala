package patterns.concept

object Client extends App {
  override def main(args: Array[String]) = {
    implicit val pe = new PersonEq
    implicit val po = new PersonOrd

    def is[T](a: T, b: T)(implicit eq: Eq[T]): Boolean = eq.==(a, b)
    def cmp[T](a: T, b: T)(implicit ord: Ord[T]): Ordering = ord.compare(a, b)

    val a = new Person("a", 10)
    val b = new Person("b", 20)

    Console println is(a, b)
    Console println cmp(a, b)
  }
}