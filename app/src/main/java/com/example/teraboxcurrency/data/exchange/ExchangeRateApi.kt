package com.example.teraboxcurrency.data.exchange

/** Provider-neutral exchange-rate API boundary. */
interface ExchangeRateApi {
    suspend fun latest(base: String, symbols: List<String>): Result<Map<String, Double>>
}

/** Safe default used until a real provider endpoint is configured. */
class ConfigurableExchangeRateApi : ExchangeRateApi {
    override suspend fun latest(base: String, symbols: List<String>): Result<Map<String, Double>> =
        Result.failure(UnsupportedOperationException("Exchange-rate API endpoint is not configured"))
}
