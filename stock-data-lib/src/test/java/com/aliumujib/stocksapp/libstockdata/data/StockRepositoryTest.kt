package com.aliumujib.stocksapp.libstockdata.data

import app.cash.turbine.test
import com.aliumujib.stocksapp.coremodels.ResponseType
import com.aliumujib.stocksapp.libstockdata.DummyData
import com.aliumujib.stocksapp.libstockdata.domain.StockRepository
import com.aliumujib.stocksapp.remote.service.StocksDataSource
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junitparams.JUnitParamsRunner
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.net.SocketTimeoutException

@RunWith(JUnitParamsRunner::class)
internal class StockRepositoryTest {

    @MockK
    lateinit var stocksDataSource: StocksDataSource

    private val sut: StockRepository by lazy {
        StockRepositoryImpl(stocksDataSource)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
    }

    @Test
    fun fetch_stocks_returns_data_when_successful() = runTest {
        // Given
        val expected = listOf(DummyData.APPLE, DummyData.MICROSOFT)
        coEvery { stocksDataSource.getStocks(ResponseType.VALID) } returns expected
        // when
        val response = sut.fetchStocks(ResponseType.VALID)
        // then
        response.test {
            Truth.assertThat(awaitItem()).isEqualTo(expected)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun fetch_stocks_emits_error_when_failed() = runTest {
        // Given
        val error = SocketTimeoutException()
        coEvery { stocksDataSource.getStocks(ResponseType.VALID) } throws error
        // when
        val response = sut.fetchStocks(ResponseType.VALID)
        // then
        response.test {
            Truth.assertThat(awaitError()).isInstanceOf(error::class.java)
            cancelAndIgnoreRemainingEvents()
        }
    }

}
