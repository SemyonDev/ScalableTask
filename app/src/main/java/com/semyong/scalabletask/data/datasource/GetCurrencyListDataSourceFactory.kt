package com.semyong.scalabletask.data.datasource


import androidx.paging.DataSource
import com.semyong.scalabletask.data.api.ApiServices
import com.semyong.scalabletask.data.entities.CurrencyItem
import com.semyong.scalabletask.data.helpers.DataErrorManager

class GetCurrencyListDataSourceFactory(private val apiServices: ApiServices, private val dataErrorManager: DataErrorManager) : DataSource.Factory<Int, CurrencyItem>()  {
    override fun create(): DataSource<Int, CurrencyItem> = GetCurrencyListPagingSource(apiServices, dataErrorManager)
}