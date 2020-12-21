package com.semyong.scalabletask.data.usecase.impl

import androidx.paging.DataSource
import com.semyong.scalabletask.data.entities.CurrencyItem
import com.semyong.scalabletask.data.repository.GetCurrencyRepository
import com.semyong.scalabletask.data.usecase.GetCurrencyUseCase

class GetCurrencyUseCaseImpl(private val getCurrencyRepository: GetCurrencyRepository): GetCurrencyUseCase {
    override suspend fun getCurrencyList(): DataSource.Factory<Int, CurrencyItem> = getCurrencyRepository.getCurrencyList()
    override suspend fun getCurrencyProfile(symbol:String) = getCurrencyRepository.getCurrencyProfile(symbol)
    override suspend fun getCurrencyTimeSeries(currency:String) = getCurrencyRepository.getCurrencyTimeSeries(currency)
}