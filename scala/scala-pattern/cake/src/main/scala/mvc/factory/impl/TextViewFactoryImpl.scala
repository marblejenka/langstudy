package mvc.factory.impl
import mvc.factory.AbstractTextViewFacotry
import mvc.factory.AbstractTextModel

class TextViewFactoryImpl extends AbstractTextViewFacotry {
  def createView(model: AbstractTextModel) = new TextViewImpl(model)
}