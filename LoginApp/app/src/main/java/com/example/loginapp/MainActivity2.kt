package com.example.loginapp

import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.File
import java.io.FileOutputStream
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {

    private lateinit var editTextAProbability: EditText
    private lateinit var editTextTrials: EditText
    private lateinit var btnSimulate: Button
    private lateinit var btnDownload: Button
    private lateinit var textViewSimulationResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        editTextAProbability = findViewById(R.id.editTextAProbability)
        editTextTrials = findViewById(R.id.editTextTrials)
        btnSimulate = findViewById(R.id.btnSimulate)
        btnDownload = findViewById(R.id.btnDownload)
        textViewSimulationResult = findViewById(R.id.textViewSimulationResult)

        btnSimulate.setOnClickListener {
            simulateEvents()
        }

        btnDownload.setOnClickListener {
            generateExcelFile()
        }
    }

    private fun simulateEvents() {
        val pA = editTextAProbability.text.toString().toDoubleOrNull() ?: return showError("Введите корректную вероятность события A")
        val trials = editTextTrials.text.toString().toIntOrNull() ?: return showError("Введите корректное количество испытаний")

        if (pA < 0 || pA > 1 || trials <= 0) {
            return showError("Введите корректные данные (0 <= вероятность <= 1, количество испытаний > 0)")
        }

        var countA = 0
        val trialsList = mutableListOf<String>()

        repeat(trials) { i ->
            val randomA = Random.nextDouble()
            if (randomA <= pA) {
                countA++
            }
            // Форматируем каждое случайное число до 6 знаков после запятой
            trialsList.add("Испытание ${i + 1}: ${String.format("%.6f", randomA)}")
        }

        val result = """
            Событие A наступило: $countA раз
            Все числа испытаний:
            ${trialsList.joinToString("\n")}
        """.trimIndent()

        textViewSimulationResult.text = result
    }

    private fun showError(message: String) {
        textViewSimulationResult.text = message
    }

    private fun generateExcelFile() {
        val pA = editTextAProbability.text.toString().toDoubleOrNull() ?: return showError("Введите корректную вероятность события A")
        val trials = editTextTrials.text.toString().toIntOrNull() ?: return showError("Введите корректное количество испытаний")

        val workbook = WorkbookFactory.create(true)

        val sheet = workbook.createSheet("Моделирование")

        val headerRow = sheet.createRow(0)
        headerRow.createCell(0).setCellValue("Номер испытания")
        headerRow.createCell(1).setCellValue("Случайное число")

        repeat(trials) { i ->
            val randomA = Random.nextDouble()
            val row = sheet.createRow(i + 1)
            row.createCell(0).setCellValue(i + 1.toDouble())
            row.createCell(1).setCellValue(randomA)
        }

        val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "modeling_results.xlsx")
        val fileOutputStream = FileOutputStream(file)
        workbook.write(fileOutputStream)
        fileOutputStream.close()

        showError("Результаты сохранены в файл Documents/modeling_results.xlsx")
    }
}
