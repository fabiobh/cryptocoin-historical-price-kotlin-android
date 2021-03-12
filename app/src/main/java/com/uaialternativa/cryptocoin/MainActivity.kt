package com.uaialternativa.cryptocoin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupMainActivityLayoutButtons()

    }

    private fun setupMainActivityLayoutButtons() {
        val bitcoin_button = findViewById(R.id.button_bitcoin) as Button
        val ethereum_button = findViewById(R.id.button_ethereum) as Button
        val chainlink_button = findViewById(R.id.button_chainlink) as Button
        val litecoin_button = findViewById(R.id.button_litecoin) as Button

        bitcoin_button.setOnClickListener {
            startNewScreen(this, TimeActivity::class.java, "btc-bitcoin")
        }
        ethereum_button.setOnClickListener {
            startNewScreen(this, TimeActivity::class.java, "eth-ethereum")
        }
        chainlink_button.setOnClickListener {
            startNewScreen(this, TimeActivity::class.java, "link-chainlink")
        }
        litecoin_button.setOnClickListener {
            startNewScreen(this, TimeActivity::class.java, "ltc-litecoin")
        }
    }


    object Foo : AppCompatActivity() {
        fun bar() = println("Method bar")
        var foo="foo"
    }

    fun a(): Int {
        return 1
    }

    companion object {
        fun a() : Int = 1
        fun longToast(ctx: Context, message: String) {
            Toast.makeText(ctx, message, Toast.LENGTH_LONG).show()
        }
        fun startNewScreen(self: Context,classe: Class<*>, coin_name: String) {
            try {
                val intent = Intent(self, classe)
                intent.putExtra("key_id", coin_name)
                self.startActivity(intent)
            } catch (e: Exception) {
                longToast(self, "error: "+e)
            }
        }
        fun removeNotUsefulCharacters(text: String ): String {
            var string1 = text.replace("[", "")
            string1 = string1.replace("]", "")
            return string1
        }
    }


}
