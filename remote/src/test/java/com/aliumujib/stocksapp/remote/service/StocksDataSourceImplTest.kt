package com.aliumujib.stocksapp.remote.service

import android.util.MalformedJsonException
import com.aliumujib.stocksapp.coremodels.ResponseType
import com.aliumujib.stocksapp.coremodels.Stock
import com.aliumujib.stocksapp.remote.FakeStocksApiService
import com.aliumujib.stocksapp.remote.mapper.StockResponseMapper
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.Test


internal class StocksDataSourceImplTest {

    private val apiService: StocksApiService by lazy {
        FakeStocksApiService()
    }

    private val mapper: StockResponseMapper = StockResponseMapper()
    private val sut: StocksDataSourceImpl by lazy {
        StocksDataSourceImpl(apiService, mapper)
    }

    @Test
    fun assert_that_stocksDataSource_returns_valid_data_when_called_with_valid_response_type() =
        runTest {
            //GIVEN
            val expected = apiService.getValidResponse().stocks.map(mapper::toStock)
            //WHEN
            val actual = sut.getStocks(response = ResponseType.VALID)
            //THEN
            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun assert_that_stocksDataSource_returns_empty_data_when_called_with_empty_response_type() =
        runTest {
            //GIVEN
            val expected = emptyList<Stock>()
            //WHEN
            val actual = sut.getStocks(response = ResponseType.EMPTY)
            //THEN
            assertThat(actual).isEqualTo(expected)
        }

    @Test(expected = MalformedJsonException::class)
    fun assert_that_stocksDataSource_returns_error_data_when_called_with_error_response_type() =
        runTest {
            sut.getStocks(response = ResponseType.FAILURE)
        }

}