package com.semyong.scalabletask.data.usecase

import androidx.paging.DataSource
import com.semyong.scalabletask.data.entities.CurrencyItem
import com.semyong.scalabletask.data.entities.CurrencyItemData

interface GetCurrencyUseCase {
    suspend fun getCurrencyList(): DataSource.Factory<Int, CurrencyItem>
    suspend fun getCurrencyProfile(symbol: String): CurrencyItemData
    suspend fun getCurrencyTimeSeries(currency: String): CurrencyItemData
}