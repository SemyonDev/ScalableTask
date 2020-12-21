package com.semyong.scalabletask.presentation.fragments.listfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.semyong.scalabletask.data.entities.CurrencyItem
import com.semyong.scalabletask.databinding.FragmentHomelistBinding
import com.semyong.scalabletask.presentation.fragments.BaseFragment
import com.semyong.scalabletask.presentation.fragments.listfragment.adapters.CurrecnyListAdapter
import com.semyong.scalabletask.presentation.fragments.listfragment.adapters.ListItemAction
import com.semyong.scalabletask.presentation.helpers.showToastLong
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeListFragment : BaseFragment(), ListItemAction {

    private val viewModel: HomeListViewModel by viewModel()
    private val currecnyListAdapter = CurrecnyListAdapter(this)
    private lateinit var binding: FragmentHomelistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomelistBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeViewMOodel()
        viewModel.getCurrencyItems()
    }

    private fun initViews() {
        binding.currencyListSwipeContainer.isRefreshing = true
        binding.currencyListRv.apply {
            adapter = currecnyListAdapter
            layoutManager = LinearLayoutManager(context)
        }

        binding.currencyListSwipeContainer.setOnRefreshListener {
            currecnyListAdapter.submitList(null)
            viewModel.getCurrencyItems()
        }
    }

    private fun observeViewMOodel() {
        viewModel.mCurrencyListResult.observe(viewLifecycleOwner, Observer {
            it.observe(viewLifecycleOwner, Observer {
                println(it.toTypedArray().contentToString())
                currecnyListAdapter.submitList(it)
                binding.currencyListSwipeContainer.isRefreshing = false
            }
            )
        }
        )

        viewModel.mError.observe(viewLifecycleOwner, Observer { errorMessage ->
            binding.currencyListSwipeContainer.isRefreshing = false
            context?.showToastLong(errorMessage)
        })
    }

    override fun onItemClick(currencyItem: CurrencyItem) {
        goToDetailsFragment(currencyItem)
    }

    private fun goToDetailsFragment(currencyItem: CurrencyItem) {
        val action = HomeListFragmentDirections.actionGotToDetailsFragment(currencyItem)
        Navigation.findNavController(binding.currencyListRv).navigate(action)
    }

}