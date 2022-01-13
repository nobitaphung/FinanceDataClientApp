package com.androimads.retrolin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private var TAG: String = "StockDataMainAct"

    private var stockData: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stockData = findViewById(R.id.textView)

        findViewById<View>(R.id.button).setOnClickListener {
            getCurrentData()
        }
    }

    internal fun getCurrentData() {
        val retrofit = Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(StockPriceService::class.java)
        val call = service.getCurrentStockData()
        call.enqueue(object : Callback<StockDataResults> {
            override fun onResponse(call: Call<StockDataResults>, response: Response<StockDataResults>) {
                Log.e(TAG, "response code : " + response.code());
                if (response.code() == 200) {
                    val stockPriceResponse = response.body()!!
                    Log.e(TAG, "symbol: " + stockPriceResponse.symbol!!)
                    Log.e(TAG, "openPrice: " + stockPriceResponse.openPrice!!)
                    Log.e(TAG, "closePrice: " + stockPriceResponse.closePrice!!)
                    Log.e(TAG, "highestPrice: " + stockPriceResponse.highestPrice!!)
                    Log.e(TAG, "tradingVol: " + stockPriceResponse.tradingVol!!)

//                 try {
//                     val stringBuilder = "closePrice: " +
//                             stockPriceResponse.symbol!! +
//                             "\n" +
//                             "highestPrice: " +
//                             stockPriceResponse.highestPrice +
//                             "\n" +
//                             "lowestPrice: " +
//                             stockPriceResponse.lowestPrice +
//                             "\n" +
//                             "transactionNo: " +
//                             stockPriceResponse.transactionNo +
//                             "\n" +
//                             "openPrice: " +
//                             stockPriceResponse.openPrice +
//                             "\n" +
//                             "msStartTimestamp: " +
//                             stockPriceResponse.startTimestamp +
//                             "\n" +
//                             "Volume: " +
//                             stockPriceResponse.givenTimeVolume +
//                             "\n"
//                            "closePrice: " +
//                               stockPriceResponse.closePrice +
//                             "\n"
//                            "averageVolume: " +
//                             stockPriceResponse.averageVolume
//
//                     stockData!!.text = stringBuilder
//                 } catch(e : Exception) {
//                     e.printStackTrace()
//                 }

                }
            }

            override fun onFailure(call: Call<StockDataResults>, t: Throwable) {
                stockData!!.text = t.message
            }
        })
    }

    companion object {
        var BaseUrl = "http://192.168.0.12:8080/"
        var date = "2020-10-14"
    }

}
