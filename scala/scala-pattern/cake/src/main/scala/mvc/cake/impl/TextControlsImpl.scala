package mvc.cake.impl
import mvc.cake.TextControls
import mvc.cake.TextModels
import mvc.cake.TextViews

trait TextControlsImpl extends TextControls {
  self: TextModels with TextViews =>

  val model: TextModel = createModel
  val view: TextView = createView(model)
  model.addListener(view)
  
  def setText(string: String) = model.setText(string)
  def clear = model.setText("")
}