package com.semyong.scalabletask.presentation.fragments.listfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.semyong.scalabletask.data.entities.CurrencyItem
import com.semyong.scalabletask.data.helpers.DataErrorManager
import com.semyong.scalabletask.data.usecase.GetCurrencyUseCase
import com.semyong.scalabletask.presentation.fragments.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeListViewModel(
    private val getCurrencyUseCase: GetCurrencyUseCase,
    private val dataErrorManager: DataErrorManager
) : BaseViewModel() {

    protected val _error: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val mError: LiveData<String> = _error

    protected val _currencyListResult: MutableLiveData<LiveData<PagedList<CurrencyItem>>> by lazy { MutableLiveData<LiveData<PagedList<CurrencyItem>>>() }
    val mCurrencyListResult: LiveData<LiveData<PagedList<CurrencyItem>>> = _currencyListResult

    init {
        viewModelScope.launch(Dispatchers.IO) {
            dataErrorManager.throwableFlow.collect() {
                it?.let {
                    _error.postValue(it.toString())
                    Log.d("Tag", "dataErrorManager = " + it)
                }
            }
        }
    }

    fun getCurrencyItems() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            _error.postValue(throwable.stackTrace.toString())
            Log.d("Tag", "coroutineExceptionHandler = " + throwable.printStackTrace())
            throwable.printStackTrace()
        }

        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val pageConfig = PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(20).build()

            val dataSourceFactory = getCurrencyUseCase.getCurrencyList()

            withContext(Dispatchers.Main) {
                _currencyListResult.postValue(LivePagedListBuilder(dataSourceFactory, pageConfig).build())
            }
        }
    }

}