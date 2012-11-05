package mvc.cake.impl
import mvc.cake.TextViews
import mvc.cake.TextModels

trait TextViewsImpl extends TextViews {
  self: TextModels =>

  def createView(model: TextModel): TextView = new TextViewImpl(model)

  class TextViewImpl(model: TextModel) extends TextView {
    def draw = Console println model.getText
    def signal = draw
  }
}