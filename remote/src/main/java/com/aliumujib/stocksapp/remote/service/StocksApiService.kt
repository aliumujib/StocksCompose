package com.aliumujib.stocksapp.remote.service

import com.aliumujib.stocksapp.remote.model.StocksResponse
import retrofit2.http.GET

internal interface StocksApiService {

    @GET("cash-stocks-api/portfolio.json")
    suspend fun getValidResponse(): StocksResponse

    @GET("cash-stocks-api/portfolio_empty.json")
    suspend fun getEmptyResponse(): StocksResponse

    @GET("cash-stocks-api/portfolio_malformed.json")
    suspend fun getMalformedResponse(): StocksResponse

}
