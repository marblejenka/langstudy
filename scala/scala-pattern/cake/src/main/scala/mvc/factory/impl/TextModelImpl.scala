package mvc.factory.impl
import mvc.factory.AbstractTextView
import mvc.factory.AbstractTextModel

class TextModelImpl extends AbstractTextModel {
  var text = ""
  var vs: List[AbstractTextView] = Nil

  def getText = text
  def setText(string: String): Unit = {
    text = string
    for (v <- vs) {
      Console println "fire signal to " + v
      v.signal
    }
  }

  def addListener(view: AbstractTextView): Unit = {
    vs = view :: vs
  }
}