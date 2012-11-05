trait Eq[T] {
  def ==(a: T, b: T): Boolean
  def ne(a: T, b: T): Boolean = !(a == b)
}

class PersonEq extends Eq[Person] {
  def ==(a: Person, b: Person): Boolean = a.name == b.name
}
