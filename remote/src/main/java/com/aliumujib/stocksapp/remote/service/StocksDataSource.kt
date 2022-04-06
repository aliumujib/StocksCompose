package com.aliumujib.stocksapp.remote.service

import com.aliumujib.stocksapp.coremodels.ResponseType
import com.aliumujib.stocksapp.coremodels.Stock


public interface StocksDataSource {
    public suspend fun getStocks(response: ResponseType):List<Stock>
}