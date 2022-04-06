package com.aliumujib.stocksapp.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.ComposeView
import com.aliumujib.android.stocksapp.composecommons.StockTheme
import com.aliumujib.android.stocksapp.portfolio.ui.Portfolio
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val composeView = ComposeView(this).apply {
            setContent {
                PortfolioContent()
            }
        }

        setContentView(composeView)
    }

    @Composable
    private fun PortfolioContent() {
        CompositionLocalProvider{
            StockTheme {
                Portfolio()
            }
        }
    }


}
