import mvc.cake.impl.TextControlsImpl
import mvc.cake.TextControls
import mvc.factory.impl.TextModelFactoryImpl
import mvc.factory.impl.TextViewFactoryImpl
import mvc.factory.AbstractTextModelFactory
import mvc.factory.AbstractTextViewFacotry
import mvc.cake.impl.TextViewsImpl
import mvc.cake.impl.TextModelsImpl

object Client extends App {

  class ComponentByFactory(modelFactory: AbstractTextModelFactory, viewFactory: AbstractTextViewFacotry) {
    private val model = modelFactory.createModel
    private val view = viewFactory.createView(model)
    model.addListener(view)

    def setText(string: String) = model.setText(string)
    def clear = model.setText("")
  }

  override def main(args: Array[String]) = {
    val componentByFactory = new ComponentByFactory(new TextModelFactoryImpl, new TextViewFactoryImpl)
    componentByFactory.setText("abstract factory testing")
    
    val cakeComponent = new TextModelsImpl with TextViewsImpl with TextControlsImpl
    cakeComponent.setText("cake testing")
  }
}