package com.semyong.scalabletask.di

import com.semyong.scalabletask.presentation.fragments.detailsfragment.HomeListDetailsViewModel
import com.semyong.scalabletask.presentation.fragments.listfragment.HomeListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module {
    viewModel { HomeListViewModel(get(), get()) }
    viewModel { HomeListDetailsViewModel(get()) }
}
