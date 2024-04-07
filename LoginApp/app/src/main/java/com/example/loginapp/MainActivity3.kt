package com.example.loginapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity3 : AppCompatActivity() {

    private lateinit var edtEventProbabilities: EditText
    private lateinit var edtTrialCount: EditText
    private lateinit var btnSimulate: Button
    private lateinit var txtResults: TextView
    private lateinit var scrollView: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        edtEventProbabilities = findViewById(R.id.edtEventProbabilities)
        edtTrialCount = findViewById(R.id.edtTrialCount)
        btnSimulate = findViewById(R.id.btnSimulate)
        txtResults = findViewById(R.id.txtResults)
        scrollView = findViewById(R.id.scrollView)

        btnSimulate.setOnClickListener {
            simulateEvents()
        }
    }

    private fun simulateEvents() {
        val probabilitiesText = edtEventProbabilities.text.toString()
        val trialCountText = edtTrialCount.text.toString()

        val probabilities = probabilitiesText.split(",").map { it.trim().toDoubleOrNull() }
        val trialCount = trialCountText.toIntOrNull()

        if (probabilities.any { it == null } || trialCount == null || probabilities.isEmpty() || trialCount <= 0) {
            showError("Введите корректные данные")
            return
        }

        val sum = probabilities.sumByDouble { it ?: 0.0 }
        if (sum != 1.0) {
            showError("Сумма вероятностей должна быть равна 1")
            return
        }

        val eventNames = ('A'..'Z').take(probabilities.size)
        val eventCounts = IntArray(probabilities.size)
        val trialResults = mutableListOf<String>()

        repeat(trialCount) { trial ->
            val random = Random.nextDouble()
            var sum = 0.0
            var eventIndex = -1

            for (index in probabilities.indices) {
                sum += probabilities[index] ?: 0.0
                if (random < sum) {
                    eventIndex = index
                    eventCounts[index]++
                    break
                }
            }

            if (eventIndex != -1) {
                trialResults.add("Испытание ${trial + 1}: ${String.format("%.6f", random)}")
            }
        }

        val eventCountsText = eventNames.mapIndexed { index, eventName ->
            "Событие $eventName наступило ${eventCounts[index]} раза"
        }.joinToString("\n")

        val resultText = trialResults.joinToString("\n")

        txtResults.text = "$eventCountsText\n\n$resultText"
        scrollView.fullScroll(ScrollView.FOCUS_DOWN)
    }



    private fun showError(message: String) {
        txtResults.text = message
    }
}
