package com.semyong.scalabletask.data.usecase

import androidx.paging.DataSource
import com.semyong.scalabletask.data.entities.CurrencyItem

interface GetCurrencyUseCase {
    suspend fun getCurrencyList(): DataSource.Factory<Int, CurrencyItem>
    suspend fun getCurrencyProfile(symbol:String): CurrencyItem
}