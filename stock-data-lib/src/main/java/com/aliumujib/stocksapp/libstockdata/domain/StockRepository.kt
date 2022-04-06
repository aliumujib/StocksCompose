package com.aliumujib.stocksapp.libstockdata.domain

import com.aliumujib.stocksapp.coremodels.ResponseType
import com.aliumujib.stocksapp.coremodels.Stock
import kotlinx.coroutines.flow.Flow

public interface StockRepository {
    public fun fetchStocks(responseType: ResponseType): Flow<List<Stock>>
}
