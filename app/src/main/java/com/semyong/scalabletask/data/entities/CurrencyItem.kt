package com.semyong.scalabletask.data.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrencyItem(
    @field:Json(name = "id")
    val id: String? = null,
    @field:Json(name = "name")
    val name: String? = null,
    @field:Json(name = "slug")
    val slug: String? = null,
    @field:Json(name = "symbol")
    val symbol: String? = null,
    @field:Json(name = "metrics")
    val metrics: Metrics? = null,
    @field:Json(name = "profile")
    val profile: CurrencyProfile? = null,
    @field:Json(name = "values")
    val valuesList: List<List<Double>>? = null
) : Parcelable

@Parcelize
data class MarketData(
    @field:Json(name = "price_usd")
    var priceUsd: Double? = null
) : Parcelable

@Parcelize
data class Metrics(
    @field:Json(name = "market_data")
    var marketData: MarketData? = null
) : Parcelable
