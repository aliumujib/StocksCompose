package com.aliumujib.stocksapp.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class StocksResponse(
    val stocks: List<StockItemResponse>
)

@JsonClass(generateAdapter = true)
internal data class StockItemResponse(
    val currency: String,
    val current_price_cents: Int,
    val current_price_timestamp: Long,
    val name: String,
    val quantity: Int?,
    val ticker: String
)