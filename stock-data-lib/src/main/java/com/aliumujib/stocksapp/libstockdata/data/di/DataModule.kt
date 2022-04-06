package com.aliumujib.stocksapp.libstockdata.data.di

import com.aliumujib.stocksapp.libstockdata.data.StockRepositoryImpl
import com.aliumujib.stocksapp.libstockdata.domain.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
internal interface DataModule {

    @get:Binds
    val StockRepositoryImpl.stockRepository: StockRepository

}
