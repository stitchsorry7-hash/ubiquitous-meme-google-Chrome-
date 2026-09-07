package com.example.teraboxcurrency

import java.math.BigDecimal
import java.math.RoundingMode

object CurrencyCalculator {
    fun convert(amountText: String, rateText: String): String {
        val amount = amountText.toBigDecimalOrNull() ?: BigDecimal.ZERO
        val rate = rateText.toBigDecimalOrNull() ?: BigDecimal.ZERO
        return amount.multiply(rate)
            .setScale(2, RoundingMode.HALF_UP)
            .toPlainString()
    }
}
