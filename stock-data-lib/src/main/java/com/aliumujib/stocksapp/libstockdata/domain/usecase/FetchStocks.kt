package com.aliumujib.stocksapp.libstockdata.domain.usecase

import com.aliumujib.stocksapp.coremodels.ResponseType
import com.aliumujib.stocksapp.coremodels.Stock
import com.aliumujib.stocksapp.libstockdata.AsyncDispatcher
import com.aliumujib.stocksapp.libstockdata.domain.StockRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

public class FetchStocks @Inject constructor(
    private val stockRepository: StockRepository,
    private val dispatcher: AsyncDispatcher
) {
    public data class Params constructor(
        val responseType: ResponseType
    ) {
        public companion object {
            public fun make(mode: ResponseType): Params {
                return Params(mode)
            }
        }
    }

    public fun execute(params: Params): Flow<List<Stock>> {
        return stockRepository.fetchStocks(params.responseType)
            .flowOn(dispatcher.io)
    }
}
