package com.aliumujib.stocksapp.libstockdata.data

import com.aliumujib.stocksapp.coremodels.ResponseType
import com.aliumujib.stocksapp.coremodels.Stock
import com.aliumujib.stocksapp.libstockdata.domain.StockRepository
import com.aliumujib.stocksapp.remote.service.StocksDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class StockRepositoryImpl @Inject constructor(
   private val stocksDataSource: StocksDataSource
) : StockRepository {

    override fun fetchStocks(responseType: ResponseType): Flow<List<Stock>> {
        return flow { 
            emit(stocksDataSource.getStocks(responseType))
        }
    }

}
