package com.semyong.scalabletask.data.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrencyItemData(
    @field:Json(name = "data")
    val data: CurrencyItem? = null
) : Parcelable
