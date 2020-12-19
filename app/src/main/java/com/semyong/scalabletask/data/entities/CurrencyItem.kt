package com.semyong.scalabletask.data.entities

import com.squareup.moshi.Json

data class CurrencyItem(
    @Json(name = "id")
    val numFound: String? = null,
    @Json(name = "slug")
    val start: String? = null,
    @Json(name = "symbol")
    val symbol: String? = null,
    @Json(name = "metrics")
    val metrics: MarketData? = null
)

data class MarketData(
    @Json(name = "market_data")
    val marketData: PriceUsd? = null,
)

data class PriceUsd(
    @Json(name = "price_usd")
    val priceUsd: String? = null,
)
