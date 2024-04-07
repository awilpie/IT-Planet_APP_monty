package com.example.loginapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity9 : AppCompatActivity() {

    private lateinit var editTextA: EditText
    private lateinit var editTextB: EditText
    private lateinit var editTextModulus: EditText
    private lateinit var editTextTrials: EditText
    private lateinit var btnGenerate: Button
    private lateinit var textViewResults: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

        editTextA = findViewById(R.id.editTextA)
        editTextB = findViewById(R.id.editTextB)
        editTextModulus = findViewById(R.id.editTextModulus)
        editTextTrials = findViewById(R.id.editTextTrials)
        btnGenerate = findViewById(R.id.btnGenerate)
        textViewResults = findViewById(R.id.textViewResults)

        btnGenerate.setOnClickListener {
            generateRandomNumbers()
        }
    }

    private fun generateRandomNumbers() {
        val a = editTextA.text.toString().toIntOrNull() ?: return
        val b = editTextB.text.toString().toIntOrNull() ?: return
        val modulus = editTextModulus.text.toString().toIntOrNull() ?: return
        val trials = editTextTrials.text.toString().toIntOrNull() ?: return

        val randomNumbers = mutableListOf<Int>()

        var z = 0
        repeat(trials) {
            z = (a * z + b) % modulus
            randomNumbers.add(z)
        }

        textViewResults.text = randomNumbers.joinToString(", ")
    }
}
