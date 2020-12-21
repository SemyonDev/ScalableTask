package com.semyong.scalabletask.data.repository.impl

import androidx.paging.DataSource
import com.semyong.scalabletask.data.api.ApiServices
import com.semyong.scalabletask.data.datasource.GetCurrencyListDataSourceFactory
import com.semyong.scalabletask.data.entities.CurrencyItem
import com.semyong.scalabletask.data.entities.CurrencyItemData
import com.semyong.scalabletask.data.repository.GetCurrencyRepository

class GetCurrencyRepositoryImpl(
    private val getCurrencyListDataSourceFactory: GetCurrencyListDataSourceFactory,
    private val apiServices: ApiServices,
) : GetCurrencyRepository {
    override suspend fun getCurrencyList(): DataSource.Factory<Int, CurrencyItem> =
        getCurrencyListDataSourceFactory

    override suspend fun getCurrencyProfile(symbol: String): CurrencyItemData =
        apiServices.getCurrencyProfile(symbol)

    override suspend fun getCurrencyTimeSeries(currency: String): CurrencyItemData =
        apiServices.getCurrencyTimeSeries(currency)
}