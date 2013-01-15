package dsl
import api.Instrument
import api.Account
import api.Market
import api.Currency
import api.DiscountBond
import api.ClientAccount

object TradeImplicits {
  type Quantity = Int
  type WithInstrumentQuantity = (Instrument, Quantity)
  type WithAccountInstrumentQuanityt = (Account, Instrument, Quantity)
  type WithMarketAccountInstrumentQuantity = (Market, Account, Instrument, Quantity)
  type Money = (Int, Currency)

  class InstrumentHelper(quantity: Quantity) {
    def discountBonds(bond: DiscountBond) = (bond, quantity)
  }
  class AccountHelper(quantity: WithInstrumentQuantity) {
    def forClient(account: ClientAccount) = (account, quantity._1, quantity._2)
  }

}