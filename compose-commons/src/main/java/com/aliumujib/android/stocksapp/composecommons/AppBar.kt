package com.aliumujib.android.stocksapp.composecommons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
public fun StocksAppBar(
    title: String = stringResource(R.string.stocks_app_name)
) {
    TopAppBar(
        elevation = 6.dp,
        modifier = Modifier.height(58.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}