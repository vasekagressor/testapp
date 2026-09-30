package com.vasek.testapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textCounter = findViewById<TextView>(R.id.textCounter)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnNull = findViewById<Button>(R.id.btnNull)

        btnPlus.setOnClickListener {
            counter++
            textCounter.text = counter.toString()
            updateUI()
        }

        btnMinus.setOnClickListener {
            if (counter > 0) {
                counter--
                textCounter.text = counter.toString()
                updateUI()
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.error_below_zero),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnNull.setOnClickListener {
            counter = 0
            textCounter.text = counter.toString()
            updateUI()
        }
    }

    private fun updateUI() {
        val textCounter = findViewById<TextView>(R.id.textCounter)
        textCounter.text = counter.toString()

        if (counter >= 10) {
            textCounter.setTextColor(getColor(R.color.counter_warning))
        } else {
            textCounter.setTextColor(getColor(R.color.counter_normal))
        }
    }
}