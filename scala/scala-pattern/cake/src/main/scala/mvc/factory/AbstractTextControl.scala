package mvc.factory

trait AbstractTextControl {
  def setText(string: String): Unit
  def clear: Unit
}