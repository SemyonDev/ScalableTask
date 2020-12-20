package com.semyong.scalabletask.data.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrencyProfile(
    @field:Json(name = "id")
    val id: String? = null,
    @field:Json(name = "name")
    val name: String? = null,
    @field:Json(name = "slug")
    val slug: String? = null,
    @field:Json(name = "symbol")
    val symbol: String? = null,
    @field:Json(name = "metrics")
    val metrics: Metrics? = null
) : Parcelable

