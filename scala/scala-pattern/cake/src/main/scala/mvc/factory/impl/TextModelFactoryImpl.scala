package mvc.factory.impl
import mvc.factory.AbstractTextModelFactory

class TextModelFactoryImpl extends AbstractTextModelFactory {
  def createModel = new TextModelImpl
}