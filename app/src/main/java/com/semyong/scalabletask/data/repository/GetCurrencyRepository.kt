package com.semyong.scalabletask.data.repository

import androidx.paging.DataSource
import com.semyong.scalabletask.data.entities.CurrencyItem

interface GetCurrencyRepository {
    suspend fun getCurrencyList(): DataSource.Factory<Int, CurrencyItem>
    suspend fun getCurrencyProfile(symbol:String): CurrencyItem
}