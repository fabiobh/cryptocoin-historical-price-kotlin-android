package com.uaialternativa.cryptocoin

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.time.Year

class TimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.time_activity_layout)

        val key_id = intent.getStringExtra("key_id")
        //MainActivity.longToast(this, "teste3: "+key_id)

        val year_button = findViewById<Button>(R.id.button_year)
        val month_button = findViewById(R.id.button_month) as Button
        val day_button = findViewById(R.id.button_day) as Button

        year_button.setOnClickListener {
            MainActivity.startNewScreen(this, YearActivity::class.java, key_id)
        }








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
