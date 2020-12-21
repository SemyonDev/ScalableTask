package com.semyong.scalabletask.data.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrencyProfile(
    @field:Json(name = "general")
    var general: General? = null
) : Parcelable

@Parcelize
data class General(
    @field:Json(name = "overview")
    var overview: Overview? = null
) : Parcelable

@Parcelize
data class Overview(
    @field:Json(name = "tagline")
    var tagline: String? = null,
    @field:Json(name = "project_details")
    var projectDetails: String? = null,
    @field:Json(name = "official_links")
    var officialLinks: List<OfficialLinks>? = null
) : Parcelable

@Parcelize
data class OfficialLinks(
    @field:Json(name = "name")
    var name: String? = null,
    @field:Json(name = "link")
    var link: String? = null
) : Parcelable
