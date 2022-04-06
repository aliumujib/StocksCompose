package com.aliumujib.android.stocksapp.portfolio.presentation

import app.cash.turbine.test
import com.aliumujib.android.stocksapp.portfolio.FakeStocksRepository
import com.aliumujib.android.stocksapp.portfolio.StandardTestAsyncDispatcher
import com.aliumujib.android.stocksapp.portfolio.Utils
import com.aliumujib.stocksapp.coremodels.ResponseType
import com.aliumujib.stocksapp.libstockdata.domain.StockRepository
import com.aliumujib.stocksapp.libstockdata.domain.usecase.FetchStocks
import com.google.common.truth.Truth
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestResult
import kotlinx.coroutines.test.runTest
import org.junit.Test

public class PortfolioListViewModelTest {

    private val repository: StockRepository = FakeStocksRepository()
    private val testDispatcher = StandardTestAsyncDispatcher()
    private val fetchStocks: FetchStocks = FetchStocks(repository, testDispatcher)
    private val sut = PortfolioListViewModel(fetchStocks)

    @Test
    public fun state_is_success_when_response_contains_data_and_there_is_no_error(): TestResult = runTest{
       launch { // https://github.com/cashapp/turbine/issues/33#issuecomment-846041146
           //GIVEN
           val expected = PortfolioViewState.Success(listOf(Utils.MICROSOFT, Utils.APPLE))

           //WHEN
           sut.setResponseType(ResponseType.VALID)

           //THEN
           sut.state.test {
               Truth.assertThat(awaitItem()).isEqualTo(PortfolioViewState.Loading)
               Truth.assertThat(awaitItem()).isEqualTo(expected)
               awaitComplete()
           }
       }
    }

    @Test
    public fun state_is_success_when_response_contains_no_data_and_there_is_no_error(): TestResult = runTest{
        launch {
            //GIVEN
            val expected = PortfolioViewState.Success(listOf())

            //WHEN
            sut.setResponseType(ResponseType.EMPTY)

            //THEN
            sut.state.test {
                Truth.assertThat(awaitItem()).isEqualTo(PortfolioViewState.Loading)
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                awaitComplete()
            }
        }
    }

    @Test
    public fun state_is_error_when_response_contains_no_data_and_there_is_an_error(): TestResult = runTest{
        launch {
            //GIVEN
            val expected = PortfolioViewState.Error("Bad JSON")

            //WHEN
            sut.setResponseType(ResponseType.FAILURE)

            //THEN
            sut.state.test {
                Truth.assertThat(awaitItem()).isEqualTo(PortfolioViewState.Loading)
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                awaitComplete()
            }
        }
    }

}