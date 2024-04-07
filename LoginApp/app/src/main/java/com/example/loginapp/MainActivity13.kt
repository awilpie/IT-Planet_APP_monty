package com.example.loginapp

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.TextView

class MainActivity13 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)

        val btnAbout = findViewById<Button>(R.id.fourthButton)
        btnAbout.setOnClickListener {
            showAboutDialog()
        }
    }

    fun goToFirstActivity(view: View) {
        val intent = Intent(this, MainActivity7::class.java)
        startActivity(intent)
    }

    fun goToSecondActivity(view: View) {
        val intent = Intent(this, MainActivity14::class.java)
        startActivity(intent)
    }

    fun goToThirdActivity(view: View) {
        val intent = Intent(this, MainActivity5::class.java)
        startActivity(intent)
    }
    fun goToFouthActivity(view: View) {
        showAboutDialog()
    }
    private fun showAboutDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.custom_about_dialog, null)

        // Настройка текста в диалоговом окне
        val textView = dialogView.findViewById<TextView>(R.id.aboutTextView)
        textView.text = "Обучающая система по дисциплине \"Компьютерное моделирование\"\n" +
                "Разработал: Зейнегабылов.А Алимбекова.А\n" +
                "Версия 0.1\n" +
                "Алматы 2024"
        textView.setTextColor(Color.BLACK)
        textView.textSize = 16f
        textView.gravity = Gravity.CENTER
        textView.typeface = Typeface.DEFAULT_BOLD

        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()

        // Настройка фона диалогового окна
        dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_background)

        dialog.show()
    }
}
