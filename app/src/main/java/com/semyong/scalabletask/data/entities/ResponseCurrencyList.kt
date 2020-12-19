package com.semyong.scalabletask.data.entities

import com.squareup.moshi.Json

data class ResponseCurrencyList(
    @Json(name = "data")
    val data: List<CurrencyItem>? = null,
)
