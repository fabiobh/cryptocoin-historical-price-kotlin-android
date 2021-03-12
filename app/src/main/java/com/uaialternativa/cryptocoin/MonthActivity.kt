package com.uaialternativa.cryptocoin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.time.Year

class MonthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.time_activity_layout)

        val intent = intent
        val key_id = intent.getStringExtra("key_id")






        /*
        val btn = findViewById(R.id.button) as Button
        btn.setOnClickListener {
            try {
                //val url = "https://api.coingecko.com/api/v3/coins/bitcoin/history?date=30-12-2017&localization=false"
                val url = "https://api.coinpaprika.com/v1/tickers/btc-bitcoin/historical?start=2012-02-15&end=2018-02-16&limit=1"
                Fuel.get(url)
                        .response { request, response, result ->
                            val (bytes, error) = result
                            if (bytes != null) {
                                println("response.statusCode: "+response.statusCode)
                                val string0 = String(response.body().toByteArray())
                                val string1 = removeNotUsefulCharacters(string0)
                                val answer1 = JSONObject(string1)
                                println("response.body: "+string1)
                                println("response.body: "+answer1.getString("price"))
                                //Toast.makeText(this,"erro: "+e,5000).show()
                            } else {
                                println("nada")
                            }
                        }


            }
            catch (e: Exception) {
                Toast.makeText(this,"erro: "+e,5000).show()
            }
        }
        */

    }


}
