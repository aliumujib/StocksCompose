package com.aliumujib.stocksapp.libstockdata

import com.aliumujib.stocksapp.coremodels.Stock
import kotlin.random.Random


internal object DummyData{
    internal val MICROSOFT = Stock("USD", 12, Random.nextLong(), "MICROSOFT", 22, "MSFT")
    internal val BLOCK = Stock("USD", 12, Random.nextLong(), "BLOCK", 22, "SQR")
    internal val APPLE = Stock("USD", 12, Random.nextLong(), "APPLE", 22, "AAPL")
    internal val NETFLIX = Stock("USD", 12, Random.nextLong(), "NETFLIX", 22, "NTFX")

}

