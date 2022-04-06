package com.aliumujib.stocksapp.remote

import com.aliumujib.stocksapp.remote.model.StockItemResponse
import kotlin.random.Random


internal object Utils{
    internal val MICROSOFT = StockItemResponse("USD", 12, Random.nextLong(), "MICROSOFT", 22, "MSFT")
    internal val BLOCK = StockItemResponse("USD", 12, Random.nextLong(), "BLOCK", 22, "SQR")
    internal val APPLE = StockItemResponse("USD", 12, Random.nextLong(), "APPLE", 22, "AAPL")
    internal val NETFLIX = StockItemResponse("USD", 12, Random.nextLong(), "NETFLIX", 22, "NTFX")
}