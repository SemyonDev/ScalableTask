package com.semyong.scalabletask.presentation.fragments.listfragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.semyong.scalabletask.data.entities.CurrencyItem
import com.semyong.scalabletask.databinding.ItemCurrencyBinding

class CurrecnyListAdapter(val actions: ListItemAction) :
    PagedListAdapter<CurrencyItem, CurrecnyListAdapter.CurrencyViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val binding: ItemCurrencyBinding =
            ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class CurrencyViewHolder(private val binding: ItemCurrencyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                currentList?.get(adapterPosition)?.let { it1 -> actions.onItemClick(it1) }
            }
        }

        fun bind(currencyItem: CurrencyItem) {
            binding.itemCurrecnyTitle.text = currencyItem.slug
            binding.itemCurrecnySymbol.text = currencyItem.symbol
            binding.itemCurrecnyPriceUsd.text = currencyItem.metrics?.marketData?.priceUsd.toString()
        }
    }
}