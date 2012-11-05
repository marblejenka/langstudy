package mvc.cake

trait TextControls {
  self: TextModels with TextViews =>

  val model: TextModel
  val view: TextView
  def setText(stirng: String): Unit
  def clear: Unit
}