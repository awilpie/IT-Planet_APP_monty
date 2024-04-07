package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity14 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main14)
    }

    fun goToFirstActivity(view: View) {
        val intent = Intent(this, MainActivity12::class.java)
        startActivity(intent)
    }

    fun goToSecondActivity(view: View) {
        val intent = Intent(this, MainActivity15::class.java)
        startActivity(intent)
    }

    fun goToThirdActivity(view: View) {
        val intent = Intent(this, MainActivity16::class.java)
        startActivity(intent)
    }
    fun goToFouthActivity(view: View) {
        val intent = Intent(this, MainActivity17::class.java)
        startActivity(intent)
    }
    fun goToFiftActivity(view: View) {
        val intent = Intent(this, MainActivity18::class.java)
        startActivity(intent)
    }
}