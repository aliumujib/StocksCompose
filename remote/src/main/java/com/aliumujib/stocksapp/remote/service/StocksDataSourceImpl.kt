package com.aliumujib.stocksapp.remote.service

import com.aliumujib.stocksapp.coremodels.ResponseType
import com.aliumujib.stocksapp.coremodels.Stock
import com.aliumujib.stocksapp.remote.mapper.StockResponseMapper
import javax.inject.Inject


internal class StocksDataSourceImpl @Inject constructor(
    private val stocksApiService: StocksApiService,
    private val stockResponseMapper: StockResponseMapper
) : StocksDataSource {

    override suspend fun getStocks(response: ResponseType): List<Stock> {
        return when(response){
            ResponseType.VALID -> {
                stocksApiService.getValidResponse().stocks.map(stockResponseMapper::toStock)
            }
            ResponseType.EMPTY -> {
                stocksApiService.getEmptyResponse().stocks.map(stockResponseMapper::toStock)
            }
            ResponseType.FAILURE -> {
                stocksApiService.getMalformedResponse().stocks.map(stockResponseMapper::toStock)
            }
        }
    }

}