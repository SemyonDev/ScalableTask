package com.semyong.scalabletask.data.api

import com.semyong.scalabletask.data.entities.ResponseCurrencyList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("/assets")
    suspend fun getCurrencyList(
        @Query("fields") fields: String = "id,slug,symbol,metrics/market_data/price_usd",
        @Query("page") page: String
    ): ResponseCurrencyList
}