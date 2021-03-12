package com.uaialternativa.cryptocoin

import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.nio.charset.Charset
import java.time.LocalDate
import java.time.LocalDate.parse

class YearActivity : AppCompatActivity() {
    var runningTask: AsyncTask<*, *, *>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.year_layout)

        val year_layout = findViewById<LinearLayout>(R.id.yearLayout)

        val key_id = intent.getStringExtra("key_id")
        findViewById<TextView>(R.id.coinTitle).setText(key_id.toUpperCase())


        val day_button = findViewById<TextView>(R.id.coinPrice)



        doAsync {

            //val coinPrice = getCryptocoinUrl(key_id)
            val coinPrice = getUrlSync(key_id)

            year_layout.post{
                day_button.setText( coinPrice )
            }


        }

        //day_button.setText( "coinPrice2" )



    }

    private fun getCryptocoinUrl(key_id: String?): String {
        var price = ""
        try {
            //val url = "https://api.coinpaprika.com/v1/tickers/btc-bitcoin/historical?start=2011-01-01&end=2021-01-02&interval=1d&limit=5000"
            val url = "https://api.coinpaprika.com/v1/tickers/" + key_id + "/historical?start=2011-01-01&end=2021-01-02&interval=1d&limit=5000"
            Fuel.get(url).response { request, response, result ->
                        println("response.statusCode: " + response.statusCode)
                        val string0 = String(response.body().toByteArray())
                        val string1 = MainActivity.removeNotUsefulCharacters(string0)
                        val answer1 = JSONObject(string1)
                        println("response.body: " + string1)
                        println("response.body answer1: " + answer1)
                        //println("response.body: " + answer1.getString("price"))
                        //price = answer1.getString("price")
                    }


        } catch (e: Exception) {
            MainActivity.longToast(this, "erro: " + e)
        }
        return "fora"
    }

    fun getUrlSync(key_id: String): String {
        var stringToReturn = ""
        val url = "https://api.coinpaprika.com/v1/tickers/" + key_id + "/historical?start=2011-01-03&end=2021-01-02&interval=365d&limit=100"
        val (request, response, result) = url
                .httpGet()
                .responseString()

        return when (result) {
            is Result.Failure -> {
                val ex = result.getException()
                println("ex: "+ex)
                ex.toString()
            }
            is Result.Success -> {
                try {
                    val data = result.get()
                    val stream0 = (response.body().toStream())
                    val inputAsString = stream0.readTextAndClose()
                    println("response.body: " + inputAsString)
                    val answer1 = JSONArray(inputAsString)
                    for (i in 0 until answer1.length()) {
                        val item = answer1.getJSONObject(i)

                        val stringDate = item.getString("timestamp").split("T").get(0)
                        val price = item.getString("price")

                        stringToReturn = stringToReturn + stringDate + "     |     " + price + "\n"
                        println(item.getString("price"))

                    }
                } catch (e: Exception){
                    println("erro year: " + e)
                }
                stringToReturn //return

            }
        }

    }

    fun InputStream.readTextAndClose(charset: Charset = Charsets.UTF_8): String {
        return this.bufferedReader(charset).use { it.readText() }
    }

    fun getUrlAsync(url: String): String {
        val httpAsync = "https://httpbin.org/get"
                .httpGet()
                .responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val ex = result.getException()
                            println(ex)
                        }
                        is Result.Success -> {
                            val data = result.get()
                            println(data)
                        }
                    }
                }

        httpAsync.join()
        return "a"
    }

}

class doAsync(val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
    init {
        execute()
    }

    override fun doInBackground(vararg params: Void?): Void? {
        handler()
        return null
    }
}