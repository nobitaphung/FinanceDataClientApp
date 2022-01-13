package com.androimads.retrolin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StockPriceService {
    @GET("/custom/most-green")
    fun getCurrentStockData() : Call<StockDataResults>
}

