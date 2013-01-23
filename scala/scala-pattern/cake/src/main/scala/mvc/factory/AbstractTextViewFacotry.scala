package mvc.factory

trait AbstractTextViewFacotry {
  def createView(abstractModel: AbstractTextModel): AbstractTextView
}