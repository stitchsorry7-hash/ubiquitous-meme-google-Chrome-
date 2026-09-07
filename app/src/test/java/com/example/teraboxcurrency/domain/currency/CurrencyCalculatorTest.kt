package com.example.teraboxcurrency.domain.currency

import org.junit.Assert.assertEquals
import org.junit.Test

class CurrencyCalculatorTest {
    @Test fun convertsAmount() {
        assertEquals(3500.0, CurrencyCalculator.convert(100.0, 35.0), 0.000001)
    }

    @Test fun zeroRateReturnsZero() {
        assertEquals(0.0, CurrencyCalculator.convert(100.0, 0.0), 0.000001)
    }
}
