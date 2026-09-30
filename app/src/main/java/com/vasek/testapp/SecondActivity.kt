package com.vasek.testapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textResult = findViewById<TextView>(R.id.textResult)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Достаём значение из интента
        val counter = intent.getIntExtra("EXTRA_COUNTER", 0)

        // Показываем его
        textResult.text = getString(R.string.result_label, counter)

        // Обработка кнопки "Назад"
        btnBack.setOnClickListener {
            finish()   // закрыть текущую Activity → вернёмся на предыдущую
        }
    }
}