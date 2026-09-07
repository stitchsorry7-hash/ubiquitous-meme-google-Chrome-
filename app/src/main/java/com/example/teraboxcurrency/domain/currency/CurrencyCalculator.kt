package com.example.teraboxcurrency.domain.currency

object CurrencyCalculator {
    fun convert(amount: Double, rate: Double): Double {
        require(amount.isFinite()) { "Amount must be finite" }
        require(rate.isFinite() && rate >= 0.0) { "Rate must be finite and non-negative" }
        return amount * rate
    }
}
