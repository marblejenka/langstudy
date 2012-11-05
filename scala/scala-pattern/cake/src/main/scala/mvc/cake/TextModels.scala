package mvc.cake

trait TextModels {
  self: TextViews =>

  def createModel: TextModel
  trait TextModel {
    def getText: String
    def setText(string: String): Unit
    def addListener(view: TextView): Unit
  }
}