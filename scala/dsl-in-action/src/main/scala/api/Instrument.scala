package api
import java.util.Date
import java.util.Date

sealed abstract class Currency(code: String)
case object USD extends Currency("USD")
case object JPY extends Currency("JPY")
case object HKD extends Currency("HKD")

trait Instrument {
  val isin: String //XXX ?
}

case class Equity(isin: String, dateOfIssue: Date //= TODAY XXX
) extends Instrument

trait FixedIncome extends Instrument {
  def dateOfIssue: Date
  def dateOfMaturity: Date
  def nominal: BigDecimal
}

object TODAY extends Date

case class CouponBond(
  override val isin: String,
  override val dateOfIssue: Date = TODAY,
  override val dateOfMaturity: Date,
  val nominal: BigDecimal,
  val paymentSchedule: Map[String, BigDecimal]) extends FixedIncome

case class DiscountBond(
  override val isin: String,
  override val dateOfIssue: Date = TODAY,
  override val dateOfMaturity: Date,
  val nominal: BigDecimal,
  val percent: BigDecimal) extends FixedIncome
  
  



