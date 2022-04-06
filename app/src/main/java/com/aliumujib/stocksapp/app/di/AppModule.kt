package com.aliumujib.stocksapp.app.di

import com.aliumujib.stocksapp.libstockdata.AsyncDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun decimalFormatter(): DecimalFormat =
        NumberFormat.getCurrencyInstance(Locale.ENGLISH) as DecimalFormat

    @Provides
    fun coroutineScope(dispatcher: AsyncDispatcher) =
        CoroutineScope(SupervisorJob() + dispatcher.io)
}
