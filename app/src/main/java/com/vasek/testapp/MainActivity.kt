package com.vasek.testapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textCounter = findViewById<TextView>(R.id.textCounter)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnNull = findViewById<Button>(R.id.btnNull)
        val btnGoToSecond = findViewById<Button>(R.id.btnGoToSecond)
        val btnGoToThird = findViewById<Button>(R.id.btnGoToThird)
        val textDate = findViewById<TextView>(R.id.textDate)
        val textTime = findViewById<TextView>(R.id.textTime)

        // Получаем текущую дату и время
        val calendar = Calendar.getInstance()

        // Месяц (0–11), день (1–31), год
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        // Время
        val hour = calendar.get(Calendar.HOUR_OF_DAY)     // 0–23
        val minute = calendar.get(Calendar.MINUTE)
        val second = calendar.get(Calendar.SECOND)

        // Массив названий месяцев по-русски
        val months = arrayOf(
            "января", "февраля", "марта", "апреля", "мая", "июня",
            "июля", "августа", "сентября", "октября", "ноября", "декабря"
        )

        // Дата: "22 июня 2026 год"
        textDate.text = getString(R.string.date_format, months[month], day, year)

        // Время: "14:35:07"
        textTime.text = String.format(Locale.getDefault(), "%02d:%02d:%02d", hour, minute, second)

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
        btnGoToSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("EXTRA_COUNTER", counter)
            startActivity(intent)
        }
        btnGoToThird.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("EXTRA_COUNTER", counter)
            startActivity(intent)
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