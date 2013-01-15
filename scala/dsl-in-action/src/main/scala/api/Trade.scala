package api
import java.util.Date

trait Trade {
  def tradingAccount: Account
  def instrument: Instrument
  def currency: Currency
  def tradeDate: Date
  def unitPrice: BigDecimal
  def quantity: BigDecimal
  //  def marker : Market XXX
  def principal = unitPrice * quantity

  var cashValue: BigDecimal = _
  //  var taxes:Map[TaxFee, BigDecimal] = _ XXX

}

trait FixedIncomeTrade extends Trade {
  override def instrument: FixedIncome
  var accruedInterst: BigDecimal = _
}

trait EquityTrade extends Trade {
  override def instrument: Equity
}