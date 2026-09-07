package com.example.teraboxcurrency

import org.junit.Assert.assertEquals
import org.junit.Test

class CurrencyCalculatorTest {
    @Test
    fun convertsAmount() {
        assertEquals("3500.00", CurrencyCalculator.convert("100", "35"))
    }

    @Test
    fun roundsToTwoDecimalPlaces() {
        assertEquals("3.33", CurrencyCalculator.convert("1.00", "3.333"))
    }

    @Test
    fun supportsDecimalAmounts() {
        assertEquals("437.50", CurrencyCalculator.convert("12.5", "35"))
    }

    @Test
    fun zeroAmountReturnsZero() {
        assertEquals("0.00", CurrencyCalculator.convert("0", "35"))
    }

    @Test
    fun invalidAmountReturnsZero() {
        assertEquals("0.00", CurrencyCalculator.convert("abc", "35"))
    }

    @Test
    fun invalidRateReturnsZero() {
        assertEquals("0.00", CurrencyCalculator.convert("100", "abc"))
    }
}
