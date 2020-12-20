package com.semyong.scalabletask.data.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Metrics(
    @field:Json(name = "market_data")
    var marketData: MarketData? = null
) : Parcelable
