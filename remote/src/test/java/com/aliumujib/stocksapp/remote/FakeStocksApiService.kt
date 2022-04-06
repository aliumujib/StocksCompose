package com.aliumujib.stocksapp.remote

import android.util.MalformedJsonException
import com.aliumujib.stocksapp.remote.model.StockItemResponse
import com.aliumujib.stocksapp.remote.model.StocksResponse
import com.aliumujib.stocksapp.remote.service.StocksApiService

internal class FakeStocksApiService : StocksApiService{

    private var stocks = mutableListOf(Utils.MICROSOFT, Utils.APPLE)

    fun setResponse(response: List<StockItemResponse>){
        stocks.clear()
        stocks.addAll(response)
    }

    override suspend fun getValidResponse(): StocksResponse {
        return StocksResponse(stocks = stocks)
    }

    override suspend fun getEmptyResponse(): StocksResponse {
        return StocksResponse(stocks = listOf())
    }

    override suspend fun getMalformedResponse(): StocksResponse {
        throw MalformedJsonException("Bad JSON response")
    }

}