package com.aliumujib.stocksapp.remote.di

import com.aliumujib.stocksapp.remote.service.StocksApiService
import com.aliumujib.stocksapp.remote.service.StocksDataSourceImpl
import com.aliumujib.stocksapp.remote.util.RemoteFactory
import com.aliumujib.stocksapp.remote.BuildConfig
import com.aliumujib.stocksapp.remote.service.StocksDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RemoteModule {

    @get:Binds
    val StocksDataSourceImpl.stocksDataSource: StocksDataSource

    companion object {

        @[Provides Singleton]
        fun apiService(remoteFactory: RemoteFactory): StocksApiService =
            remoteFactory.createRetrofit(
                url = BuildConfig.BASE_URL,
                isDebug = BuildConfig.DEBUG
            ).create(StocksApiService::class.java)
    }
}
