package com.aliumujib.stocksapp.app

import com.aliumujib.stocksapp.libstockdata.domain.old.model.EventData
import com.aliumujib.stocksapp.libstockdata.domain.old.model.StockData
import com.aliumujib.stocksapp.libstockdata.domain.old.usecase.ObserveStockData
import com.aliumujib.stocksapp.libstockdata.domain.old.usecase.SubscribeStock
import com.aliumujib.stocksapp.libstockdata.domain.old.usecase.UnsubscribeStock
import com.aliumujib.stocksapp.app.model.DataUpdateState
import com.aliumujib.stocksapp.app.model.PercentageState
import com.aliumujib.stocksapp.app.model.StockModel
import com.aliumujib.stocksapp.app.model.ViewState
import com.aliumujib.stocksapp.app.provider.ViewStateProvider
import com.aliumujib.stocksapp.app.ui.MainViewModel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock

internal class MainViewModelTest {

    @get:Rule
    val coroutineRule = TestCoroutineRule()

    @Test
    fun `when data is loaded then the correct view state is returned`() = runTest {
        // Given
        val stockObserver = mock<ObserveStockData> {
            on { stockData } doReturn flowOf(
                listOf(
                    StockData(
                        name = "NETFLIX",
                        id = "US213444",
                        price = 2333.55,
                        openPrice = null
                    )
                )
            )
        }

        val stateProvider = mock<ViewStateProvider> {
            on { initialViewState } doReturn ViewState(
                data = listOf(
                    StockModel(
                        name = "TRIVAGO",
                        price = "--",
                        percentState = PercentageState(
                            value = "",
                            background = 0,
                            icon = 9,
                            textColor = 89
                        )
                    )
                )
            )
            on { initialLiveState } doReturn DataUpdateState(
                title = StringLiteral("Connecting ..."),
                icon = 2,
                showLiveBanner = true,
                showError = false
            )
            on {
                createState(
                    listOf(
                        StockData(
                            name = "NETFLIX",
                            "US213444",
                            price = 2333.55,
                            openPrice = null
                        )
                    )
                )
            } doReturn ViewState(
                data = listOf(
                    StockModel(
                        name = "NETFLIX", price = "2333.55 $",
                        percentState = PercentageState(
                            value = "8",
                            background = 2,
                            icon = 1,
                            textColor = 34
                        )
                    )
                )
            )
            on { dataState() } doReturn DataUpdateState(
                title = StringLiteral("Live"),
                icon = 2,
                showLiveBanner = true,
                showError = false
            )
            on {
                pausedState(EventData(time = 3L, isError = true))
            } doReturn DataUpdateState(
                title = StringLiteral("Last updated: 2 mins ago"),
                icon = 2,
                showLiveBanner = true,
                showError = true
            )
        }

        val mainViewModel = createViewModel(
            observeStockData = stockObserver,
            stateProvider = stateProvider
        )

        // when
        val state = mainViewModel.stocks

        // then
        state.test {
            assertEquals(
                ViewState(
                    data = listOf(
                        StockModel(
                            name = "TRIVAGO", price = "--",
                            percentState = PercentageState(
                                value = "8",
                                background = 2,
                                icon = 1,
                                textColor = 34
                            )
                        )
                    )
                ),
                awaitItem()
            )
        }
    }

    private fun createViewModel(
        observeStockData: ObserveStockData = mock(),
        unsubscribeAll: UnsubscribeStock = mock(),
        subscribeAll: SubscribeStock = mock(),
        stateProvider: ViewStateProvider = mock()
    ) = MainViewModel(
        observeStockData = observeStockData,
        unsubscribeAll = unsubscribeAll,
        subscribeAll = subscribeAll,
        stateProvider = stateProvider
    )
}
