package mvc.factory.impl
import mvc.factory.AbstractTextView
import mvc.factory.AbstractTextModel

class TextViewImpl(model: AbstractTextModel) extends AbstractTextView {
  def draw = Console println model.getText
  def signal = draw
}