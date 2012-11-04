package patterns.concept

sealed abstract class Ordering
case object EQ extends Ordering
case object LT extends Ordering
case object GT extends Ordering

trait Ord[T] extends Eq[T] {
  def compare(a: T, b: T): Ordering = {
    if (a == b) EQ
    else if (le(a, b)) LT
    else GT
  }

  def le(a: T, b: T): Boolean
  def lt(a: T, b: T): Boolean = compare(a, b) == LT
  def ge(a: T, b: T): Boolean = !lt(a, b)
  def gt(a: T, b: T): Boolean = compare(a, b) == GT
}

class PersonOrd extends PersonEq with Ord[Person] {
  def le(a: Person, b: Person) = a.name <= b.name
}
