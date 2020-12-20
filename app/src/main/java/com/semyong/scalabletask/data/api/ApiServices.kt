package com.semyong.scalabletask.data.api

import com.semyong.scalabletask.data.entities.CurrencyItem
import com.semyong.scalabletask.data.entities.ResponseCurrencyList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {

    @GET("/api/v2/assets")
    suspend fun getCurrencyList(
        @Query("fields", encoded = true) fields: String = "id,slug,symbol,metrics/market_data/price_usd",
        @Query("page") page: Int
    ): ResponseCurrencyList

    @GET("/api/v2/assets/{symbol}/profile")
    suspend fun getCurrencyProfile(@Path("symbol") symbol: String): CurrencyItem
}