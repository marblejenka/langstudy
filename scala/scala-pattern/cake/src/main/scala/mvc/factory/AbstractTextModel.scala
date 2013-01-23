package mvc.factory

trait AbstractTextModel {
  def getText: String
  def setText(string: String): Unit
  def addListener(view: AbstractTextView): Unit
}