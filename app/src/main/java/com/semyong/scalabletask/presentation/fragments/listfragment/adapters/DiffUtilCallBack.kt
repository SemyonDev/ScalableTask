package com.semyong.scalabletask.presentation.fragments.listfragment.adapters

import androidx.recyclerview.widget.DiffUtil
import com.semyong.scalabletask.data.entities.CurrencyItem


class DiffUtilCallBack : DiffUtil.ItemCallback<CurrencyItem>() {
    override fun areItemsTheSame(oldItem: CurrencyItem, newItem: CurrencyItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CurrencyItem, newItem: CurrencyItem): Boolean {
        return oldItem.id == newItem.id
    }

}