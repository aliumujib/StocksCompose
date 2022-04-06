package com.aliumujib.stocksapp.remote.mapper

import com.aliumujib.stocksapp.coremodels.Stock
import com.aliumujib.stocksapp.remote.Utils
import com.google.common.truth.Truth.assertThat
import org.junit.Test

internal class StockResponseMapperTest{

    private val sut = StockResponseMapper()

   @Test
   fun stock_response_mapper_correctly_maps_stockResponse_to_Stock(){
       val timeStamp = System.currentTimeMillis()
       val expected = Stock("USD", 12, timeStamp, "MICROSOFT", 22, "MSFT")
       val response = Utils.MICROSOFT.copy(current_price_timestamp = timeStamp)
       val actual = sut.toStock(response)
       assertThat(actual).isEqualTo(expected)
   }

}