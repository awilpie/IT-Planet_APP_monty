package com.example.loginapp
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity11 : AppCompatActivity() {

    private lateinit var editTextTrials: EditText
    private lateinit var editTextZ0: EditText
    private lateinit var editTextHalfDigit: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)

        // Связываем переменные с элементами из XML
        editTextTrials = findViewById(R.id.editTextTrials)
        editTextZ0 = findViewById(R.id.editTextZ0)
        editTextHalfDigit = findViewById(R.id.editTextHalfDigit)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewResult = findViewById(R.id.textViewResult)

        // Устанавливаем слушатель для кнопки
        buttonCalculate.setOnClickListener {
            // Здесь вы можете обработать ввод и вывести результат
            calculateAndShowResult()
        }
    }

    private fun calculateAndShowResult() {
        // Получаем значения из полей ввода
        val trials = editTextTrials.text.toString().toIntOrNull() ?: 0
        val z0 = editTextZ0.text.toString().toDoubleOrNull() ?: 0.0
        val halfDigit = editTextHalfDigit.text.toString().toIntOrNull() ?: 0

        // Ваш код для вычислений с использованием метода середины квадрата
        val randomNumbers = middleSquare(z0.toLong(), trials, halfDigit)

        // Выводим результат
        textViewResult.text = "Результат: $randomNumbers"
    }

    private fun middleSquare(seed: Long, iterations: Int, halfDigit: Int): List<Long> {
        var currentSeed = seed
        val result = mutableListOf<Long>()

        repeat(iterations) {
            // Возводим текущее число в квадрат
            val squared = currentSeed * currentSeed

            // Преобразуем результат в строку и находим середину с учетом половинной разрядности
            val squaredStr = squared.toString()
            val middleIndex = (squaredStr.length - halfDigit) / 2
            currentSeed = squaredStr.substring(middleIndex, middleIndex + halfDigit).toLong()

            // Добавляем текущее число в результат
            result.add(currentSeed)
        }

        return result
    }
}