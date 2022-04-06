package com.aliumujib.android.stocksapp.portfolio.presentation

import com.aliumujib.stocksapp.coremodels.Stock


internal sealed class PortfolioViewState {
    object Loading : PortfolioViewState()
    data class Success(val portfolio: List<Stock>) : PortfolioViewState()
    data class Error(val message: String?) : PortfolioViewState()
}