package com.aliumujib.android.stocksapp.portfolio.ui

import java.text.NumberFormat
import java.util.*

internal fun calculatePortfolioAmount(price: Int, quantity: Int): Double {
    return (price.toDouble() / 100) * quantity
}

internal fun Double.formatToCurrencyString(currencyCode: String): String {
    val formatter: NumberFormat = NumberFormat.getCurrencyInstance()
    formatter.maximumFractionDigits = 0
    formatter.currency = Currency.getInstance(currencyCode)
    return formatter.format(this)
}
