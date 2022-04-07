package com.aliumujib.android.stocksapp.portfolio.ui

import com.google.common.truth.Truth
import org.junit.Test

internal class UtilsKtTest {

    @Test
    internal fun test_calculatePortfolioAmount() {
        val qty = 1000
        val price = 4
        val expected = 40
        val actual = calculatePortfolioAmount(price, qty)
        Truth.assertThat(actual).isEqualTo(expected)
    }

    @Test
    internal fun test_formatToCurrencyString() {
        val expected = "US$40"
        val actual = 40.0.formatToCurrencyString("USD")
        Truth.assertThat(actual).isEqualTo(expected)
    }
}