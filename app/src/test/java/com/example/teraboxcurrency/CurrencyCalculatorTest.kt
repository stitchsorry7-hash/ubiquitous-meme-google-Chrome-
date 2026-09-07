package com.example.teraboxcurrency

import org.junit.Assert.assertEquals
import org.junit.Test

class CurrencyCalculatorTest {
    @Test
    fun convertsAmount() {
        assertEquals("3500.00", CurrencyCalculator.convert("100", "35"))
    }

    @Test
    fun invalidInputReturnsZero() {
        assertEquals("0.00", CurrencyCalculator.convert("abc", "35"))
    }
}
