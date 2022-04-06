package com.aliumujib.stocksapp.remote.mapper

import com.aliumujib.stocksapp.coremodels.Stock
import com.aliumujib.stocksapp.remote.model.StockItemResponse
import javax.inject.Inject

internal class StockResponseMapper @Inject constructor() {
    fun toStock(stock: StockItemResponse): Stock {
        return Stock(
            stock.currency,
            stock.current_price_cents,
            stock.current_price_timestamp,
            stock.name,
            stock.quantity ?: 0,
            stock.ticker
        )
    }
}
