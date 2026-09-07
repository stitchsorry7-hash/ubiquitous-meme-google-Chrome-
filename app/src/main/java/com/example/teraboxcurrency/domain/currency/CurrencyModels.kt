package com.example.teraboxcurrency.domain.currency

data class CurrencyPair(val base: String, val quote: String)
data class ExchangeRate(val pair: CurrencyPair, val rate: Double, val timestampEpochMs: Long)
