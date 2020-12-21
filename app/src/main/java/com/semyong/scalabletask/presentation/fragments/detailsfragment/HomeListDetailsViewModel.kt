package com.semyong.scalabletask.presentation.fragments.detailsfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.semyong.scalabletask.data.entities.CurrencyItem
import com.semyong.scalabletask.data.usecase.GetCurrencyUseCase
import com.semyong.scalabletask.presentation.fragments.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeListDetailsViewModel(private val getCurrencyUseCase: GetCurrencyUseCase): BaseViewModel() {

    val mCurrency: MutableLiveData<CurrencyItem> by lazy { MutableLiveData<CurrencyItem>() }
    val mCurrencyTimeSeries: MutableLiveData<CurrencyItem> by lazy { MutableLiveData<CurrencyItem>() }

    fun getCurrency(symbol:String) {
        viewModelScope.launch(Dispatchers.IO) {
            val currencyItemData = getCurrencyUseCase.getCurrencyProfile(symbol)
            withContext(Dispatchers.Main) {
                mCurrency.postValue(currencyItemData.data)
            }
        }
    }

    fun getCurrencyTimeSeries(currency:String) {
        viewModelScope.launch(Dispatchers.IO) {
            val currencyItemData = getCurrencyUseCase.getCurrencyTimeSeries(currency)
            withContext(Dispatchers.Main) {
                mCurrencyTimeSeries.postValue(currencyItemData.data)
            }
        }
    }
}