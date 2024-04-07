package com.example.loginapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity5 : AppCompatActivity() {

    private lateinit var editTextAProbability: EditText
    private lateinit var editTextBProbability: EditText
    private lateinit var editTextTrials: EditText
    private lateinit var btnSimulate: Button
    private lateinit var textViewSimulationResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        editTextAProbability = findViewById(R.id.editTextAProbability)
        editTextBProbability = findViewById(R.id.editTextBProbability)
        editTextTrials = findViewById(R.id.editTextTrials)
        btnSimulate = findViewById(R.id.btnSimulate)
        textViewSimulationResult = findViewById(R.id.textViewSimulationResult)

        btnSimulate.setOnClickListener {
            simulateTrials()
        }
    }

    // Функция для генерации случайных чисел и подсчета событий
    private fun simulateTrials() {
        // Получаем вероятности событий A и B
        val probabilityA = editTextAProbability.text.toString().toDoubleOrNull()
        val probabilityB = editTextBProbability.text.toString().toDoubleOrNull()

        // Получаем количество испытаний
        val trials = editTextTrials.text.toString().toIntOrNull()

        // Проверяем, чтобы все данные были введены корректно
        if (probabilityA == null || probabilityB == null || trials == null || probabilityA !in 0.0..1.0 || probabilityB !in 0.0..1.0 || trials <= 0) {
            textViewSimulationResult.text = "Введите корректные данные"
            return
        }

        // Счетчики для событий
        var countA = 0
        var countB = 0
        var countNotAAndNotB = 0
        var countAAndNotB = 0
        var countNotAAndB = 0
        var countAAndB = 0

        // Список для хранения чисел испытаний
        val trialsList = mutableListOf<String>()

        // Генерация случайных чисел и подсчет событий
        for (i in 0 until trials) {
            val randomA = Random.nextDouble()
            val randomB = Random.nextDouble()

            // Сохраняем числа испытаний
            trialsList.add("Испытание ${i + 1}: A=${String.format("%.6f", randomA)}, B=${String.format("%.6f", randomB)}")

            // Проверка для события A
            if (randomA <= probabilityA) {
                countA++

                // Проверка для события B
                if (randomB <= probabilityB) {
                    countAAndB++
                } else {
                    countAAndNotB++
                }
            } else {
                // Проверка для события B
                if (randomB <= probabilityB) {
                    countNotAAndB++
                } else {
                    countNotAAndNotB++
                }
            }
        }

        // Формируем строку с результатами
        val resultString = """
        |Событие A и не B наступило: $countAAndNotB
        |Событие не A и B наступило: $countNotAAndB
        |Событие A и B наступило: $countAAndB
        |Событие не A и не B наступило: $countNotAAndNotB
        |Числа испытаний:
        |${trialsList.joinToString("\n")}
    """.trimMargin()

        // Выводим результаты
        textViewSimulationResult.text = resultString
    }

}
