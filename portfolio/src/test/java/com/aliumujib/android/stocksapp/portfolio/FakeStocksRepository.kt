package com.aliumujib.android.stocksapp.portfolio

import android.util.MalformedJsonException
import com.aliumujib.stocksapp.coremodels.ResponseType
import com.aliumujib.stocksapp.coremodels.Stock
import com.aliumujib.stocksapp.libstockdata.domain.StockRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlin.random.Random

internal class FakeStocksRepository : StockRepository {

    private var stocks = mutableListOf(Utils.MICROSOFT, Utils.APPLE)


    override fun fetchStocks(responseType: ResponseType): Flow<List<Stock>> {
        return when (responseType) {
            ResponseType.VALID -> {
                flow {
                    emit(stocks)
                }
            }
            ResponseType.EMPTY -> flow {
                emit(listOf<Stock>())
            }
            ResponseType.FAILURE -> flow {
                throw MalformedJsonException("Bad JSON")
            }
        }
    }

}

internal object Utils {
    internal val MICROSOFT = Stock("USD", 12, Random.nextLong(), "MICROSOFT", 22, "MSFT")
    internal val APPLE = Stock("USD", 12, Random.nextLong(), "APPLE", 22, "AAPL")
}