package com.aliumujib.android.stocksapp.portfolio.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aliumujib.android.stocksapp.composecommons.StocksAppBar
import com.aliumujib.android.stocksapp.composecommons.ToggleButtonGroup
import com.aliumujib.android.stocksapp.composecommons.WindowBg
import com.aliumujib.android.stocksapp.composecommons.rememberStateWithLifecycle
import com.aliumujib.android.stocksapp.portfolio.R
import com.aliumujib.android.stocksapp.portfolio.presentation.PortfolioListViewModel
import com.aliumujib.android.stocksapp.portfolio.presentation.PortfolioViewState
import com.aliumujib.stocksapp.coremodels.ResponseType
import com.aliumujib.stocksapp.coremodels.Stock
import java.text.NumberFormat
import java.util.*

@Composable
public fun Portfolio() {
    Portfolio(hiltViewModel())
}

@Composable
internal fun Portfolio(viewModel: PortfolioListViewModel) {
    val viewState: PortfolioViewState by rememberStateWithLifecycle(viewModel.state)
    val responseType: ResponseType by rememberStateWithLifecycle(viewModel.responseType)
    Column {
        StocksAppBar()
        PortfolioContent(
            viewState = viewState,
            responseType = responseType,
            onClick = { newResponseType ->
                viewModel.setResponseType(newResponseType)
            })
    }
}

@Composable
internal fun ResponseTypeSelector(responseType: ResponseType, onClick: (ResponseType) -> Unit) {
    val items = listOf("Success", "Empty", "Error")
    ToggleButtonGroup(responseType.value, items) {
        onClick(ResponseType.fromValue(it))
    }
}

@Composable
internal fun PortfolioContent(
    viewState: PortfolioViewState,
    responseType: ResponseType,
    onClick: (ResponseType) -> Unit
) {
    when (viewState) {
        is PortfolioViewState.Error -> {
            Column {
                ResponseTypeSelector(responseType = responseType, onClick)
                StateMessageView(
                    modifier = Modifier.fillMaxSize(),
                    icon = Icons.Default.Close,
                    stateMessage = stringResource(
                        id = R.string.portfolio_error_message
                    )
                )
            }
        }
        PortfolioViewState.Loading -> {
            Column(
                Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(color = Color.DarkGray)
            }
        }
        is PortfolioViewState.Success -> {
            Column {
                ResponseTypeSelector(responseType = responseType, onClick)
                StockList(stocks = viewState.portfolio)
            }
        }
    }
}

@Composable
internal fun StockList(stocks: List<Stock>) {
    if (stocks.isEmpty()) {
        StateMessageView(
            modifier = Modifier.fillMaxSize(),
            icon = Icons.Default.Info,
            stateMessage = stringResource(id = R.string.portfolio_no_data_to_display)
        )
        return
    }

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(stocks) { stock ->
                StockItem(stock = stock)
            }
        })
}

@Composable
internal fun StockItem(stock: Stock) {
    Card(border = BorderStroke(1.dp, WindowBg)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stock.name, modifier = Modifier.weight(weight = 1f, fill = false))
            Text(
                text = calculatePortfolioAmount(
                    stock.currentPriceCents,
                    stock.quantity
                ).formatToCurrencyString(stock.currency)
            )
        }
    }
}

internal fun calculatePortfolioAmount(price: Int, quantity: Int): Double {
    return (price.toDouble() / 100) * quantity
}

internal fun Double.formatToCurrencyString(currencyCode: String): String {
    val formatter: NumberFormat = NumberFormat.getCurrencyInstance()
    formatter.maximumFractionDigits = 0
    formatter.currency = Currency.getInstance(currencyCode)
    return formatter.format(this)
}

@Composable
internal fun StateMessageView(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    stateMessage: String
) {
    return Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = icon,
            contentDescription = "state_message",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(110.dp)
        )

        Text(
            text = stateMessage,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(PaddingValues(horizontal = 16.dp, vertical = 16.dp))
        )
    }
}