package com.aliumujib.stocksapp.coremodels

public data class Stock(
    val currency: String,
    val currentPriceCents: Int,
    val currentPriceTimestamp: Long,
    val name: String,
    val quantity: Int,
    val ticker: String
)