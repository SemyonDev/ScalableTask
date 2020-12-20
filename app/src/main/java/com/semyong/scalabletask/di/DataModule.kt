package com.semyong.scalabletask.di

import com.semyong.scalabletask.data.datasource.GetCurrencyListDataSourceFactory
import com.semyong.scalabletask.data.helpers.DataErrorManager
import com.semyong.scalabletask.data.repository.GetCurrencyRepository
import com.semyong.scalabletask.data.repository.impl.GetCurrencyRepositoryImpl
import com.semyong.scalabletask.data.usecase.GetCurrencyUseCase
import com.semyong.scalabletask.data.usecase.impl.GetCurrencyUseCaseImpl
import org.koin.dsl.module

val dataModule = module {
    single { GetCurrencyListDataSourceFactory(get(), get()) }
}

val errorManagerModule = module {
    single { DataErrorManager() }
}

val useCaseModule = module {
    single<GetCurrencyUseCase> { GetCurrencyUseCaseImpl(get()) }
}

val repositoryModule = module {
    single<GetCurrencyRepository> { GetCurrencyRepositoryImpl(get(), get()) }
}