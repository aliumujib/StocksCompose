package com.aliumujib.android.stocksapp.portfolio.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliumujib.stocksapp.coremodels.ResponseType
import com.aliumujib.stocksapp.libstockdata.domain.usecase.FetchStocks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class PortfolioListViewModel @Inject constructor(
    private val fetchStocks: FetchStocks
) : ViewModel() {

    val responseType = MutableStateFlow(ResponseType.VALID)

    val state: StateFlow<PortfolioViewState> = responseType.flatMapMerge { responseType ->
        fetchStocks.execute(FetchStocks.Params(responseType))
            .map {
                PortfolioViewState.Success(portfolio = it) as PortfolioViewState
            }
            .onStart {
                emit(PortfolioViewState.Loading)
            }
            .catch {
                emit(PortfolioViewState.Error(it.message))
            }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = PortfolioViewState.Loading
    )


    fun setResponseType(mode: ResponseType) {
        responseType.value = mode
    }
}
