package com.aliumujib.stocksapp.libstockdata.domain.di

import com.aliumujib.stocksapp.libstockdata.AsyncDispatcher
import com.aliumujib.stocksapp.libstockdata.DefaultAsyncDispatcher
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
internal interface DomainModule {

    @get:[Binds Singleton]
    val DefaultAsyncDispatcher.dispatcher: AsyncDispatcher

}
