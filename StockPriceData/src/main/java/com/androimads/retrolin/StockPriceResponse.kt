package com.androimads.retrolin

import com.google.gson.annotations.SerializedName

/**
 * Created by pmkha on 28-12-2021.
 */


class StockDataResults {
    @SerializedName("closePrice")
    var closePrice: Float? = null

    @SerializedName("highestPrice")
    var highestPrice : Float? = null

    @SerializedName("lowestPrice")
    var lowestPrice: Float? = null

    @SerializedName("noTransaction")
    var noTransaction: Float? = null

    @SerializedName("openPrice")
    var openPrice: Double? = null

    @SerializedName("startTimestamp")
    var startTimestamp: Long? = null

    @SerializedName("tradingVol")
    var tradingVol: Float? = null

    @SerializedName("startTimeStamp")
    var symbol: String? = null

    @SerializedName("averagePrice")
    var averagePrice: Float? = null
}

