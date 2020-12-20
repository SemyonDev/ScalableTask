package com.semyong.scalabletask.presentation.fragments.listfragment.adapters

import com.semyong.scalabletask.data.entities.CurrencyItem


interface ListItemAction {
    fun onItemClick(currencyItem: CurrencyItem)
}