package com.semyong.scalabletask.data.repository

import androidx.paging.DataSource
import com.semyong.scalabletask.data.entities.CurrencyItem
import com.semyong.scalabletask.data.entities.CurrencyItemData

interface GetCurrencyRepository {
    suspend fun getCurrencyList(): DataSource.Factory<Int, CurrencyItem>
    suspend fun getCurrencyProfile(symbol: String): CurrencyItemData
    suspend fun getCurrencyTimeSeries(currency: String): CurrencyItemData
}