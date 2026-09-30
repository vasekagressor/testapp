package com.vasek.testapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val textResult = findViewById<TextView>(R.id.textResult)
        val btnMain = findViewById<Button>(R.id.btnMain)
        val btnSecond = findViewById<Button>(R.id.btnSecond)

        // Достаём значение из интента
        val counter = intent.getIntExtra("EXTRA_COUNTER", 0)

        // Показываем его
        textResult.text = getString(R.string.result_label_third, counter)

        // Обработка кнопки "Назад"
        btnMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}