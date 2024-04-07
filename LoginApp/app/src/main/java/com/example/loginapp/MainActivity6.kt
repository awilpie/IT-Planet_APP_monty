package com.example.loginapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity6 : AppCompatActivity() {

    private lateinit var editTextAProbability: EditText
    private lateinit var editTextBProbability: EditText
    private lateinit var editTextConditionalProbability: EditText
    private lateinit var editTextTrials: EditText
    private lateinit var btnSimulate: Button
    private lateinit var textViewDependentSimulationResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        editTextAProbability = findViewById(R.id.editTextAProbability)
        editTextBProbability = findViewById(R.id.editTextBProbability)
        editTextConditionalProbability = findViewById(R.id.editTextConditionalProbability)
        editTextTrials = findViewById(R.id.editTextTrials)
        btnSimulate = findViewById(R.id.btnSimulate)
        textViewDependentSimulationResult = findViewById(R.id.textViewDependentSimulationResult)

        btnSimulate.setOnClickListener {
            simulateDependentEvents()
        }
    }

    private fun simulateDependentEvents() {
        val pA = editTextAProbability.text.toString().toDoubleOrNull() ?: return showError("Введите корректную вероятность события A")
        val pB = editTextBProbability.text.toString().toDoubleOrNull() ?: return showError("Введите корректную вероятность события B")
        val pBA = editTextConditionalProbability.text.toString().toDoubleOrNull() ?: return showError("Введите корректную условную вероятность P(B|A)")
        val trials = editTextTrials.text.toString().toIntOrNull() ?: return showError("Введите корректное количество испытаний")

        if (pA < 0 || pA > 1 || pB < 0 || pB > 1 || pBA < 0 || pBA > 1 || trials <= 0) {
            return showError("Введите корректные данные (0 <= вероятность <= 1, количество испытаний > 0)")
        }

        var countA = 0
        var countB = 0
        var countNotA = 0
        var countNotB = 0
        var countAB = 0
        var countNotAB = 0

        val trialsList = mutableListOf<String>()

        repeat(trials) {
            val zj = Random.nextDouble()
            val zj1 = Random.nextDouble()

            if (zj <= pA) {
                countA++
                if (zj1 <= pB) {
                    countB++
                    countAB++
                } else {
                    countNotB++
                }
            } else {
                countNotA++
                if (zj1 > pB) {
                    countNotAB++
                }
            }
            trialsList.add("Испытание ${it + 1}: A=${String.format("%.6f", zj)}, B=${String.format("%.6f", zj1)}")
        }

        val result = """
            Событие A и не B наступило: $countA раз
            Событие не A и B наступило: $countB раз
            Событие A и B наступило: $countAB раз
            Событие не A и не B наступило: ${trials - (countA + countB - countAB)} раз
            """.trimIndent()

        textViewDependentSimulationResult.text = result + "\n\n" + trialsList.joinToString("\n")
    }

    private fun showError(message: String) {
        textViewDependentSimulationResult.text = message
    }
}
