package mvc.factory

trait AbstractTextView {
  def draw: Unit
  def signal: Unit
}