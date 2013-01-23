package mvc.cake

trait TextViews {
  self: TextModels =>

  def createView(model: TextModel): TextView
  trait TextView {
    def draw: Unit
    def signal: Unit
  }
}