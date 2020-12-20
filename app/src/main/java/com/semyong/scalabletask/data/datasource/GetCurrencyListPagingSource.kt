package com.semyong.scalabletask.data.datasource

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.semyong.scalabletask.data.api.ApiServices
import com.semyong.scalabletask.data.entities.CurrencyItem
import com.semyong.scalabletask.data.helpers.DataErrorManager
import kotlinx.coroutines.runBlocking

class GetCurrencyListPagingSource(
    private val apiServices: ApiServices,
    private val dataErrorManager: DataErrorManager
) : PageKeyedDataSource<Int, CurrencyItem>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CurrencyItem>
    ) {
        runBlocking {
            try {
                val responseCurrencyList = apiServices.getCurrencyList(page = 1)
                callback.onResult(responseCurrencyList.data ?: emptyList<CurrencyItem>(), null, 2)
            } catch (throwable: Throwable) {
                dataErrorManager.flow(throwable)
                Log.d("Error", "throwable =" + throwable)
            }
        }

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CurrencyItem>) {
        runBlocking {
            val pageNumber = params.key
            try {
                val responseCurrencyList = apiServices.getCurrencyList(page = pageNumber)

                val data = responseCurrencyList.data
                callback.onResult(
                    data ?: emptyList<CurrencyItem>(),
                    params.key + 1
                )
            } catch (throwable: Throwable) {
                dataErrorManager.flow(throwable)
                Log.d("Error", "throwable =" + throwable)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CurrencyItem>) = Unit

}