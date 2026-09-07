package com.example.teraboxcurrency

import java.util.Locale

object CurrencyCalculator {
    fun convert(amountText: String, rateText: String): String {
        val amount = amountText.toDoubleOrNull() ?: 0.0
        val rate = rateText.toDoubleOrNull() ?: 0.0
        return String.format(Locale.US, "%.2f", amount * rate)
    }
}
