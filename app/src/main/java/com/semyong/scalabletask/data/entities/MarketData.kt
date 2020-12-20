package com.semyong.scalabletask.data.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarketData(
    @field:Json(name = "price_usd")
    var priceUsd: Double? = null
) : Parcelable