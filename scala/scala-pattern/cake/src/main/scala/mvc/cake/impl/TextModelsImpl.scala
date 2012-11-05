package mvc.cake.impl
import mvc.cake.TextModels
import mvc.cake.TextViews

trait TextModelsImpl extends TextModels {
  self: TextViews =>

  def createModel: TextModel = new TextModelImpl

  class TextModelImpl extends TextModel {
    var text = ""
    var vs: List[TextView] = Nil

    def getText = text
    def setText(string: String): Unit = {
      text = string
      for (v <- vs) {
        Console println "fire signal to " + v
        v.signal
      }
    }

    def addListener(view: TextView): Unit = {
      vs = view :: vs
    }
  }
}