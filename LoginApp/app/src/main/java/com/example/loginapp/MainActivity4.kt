package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
    }

    fun goToFirstActivity(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    fun goToSecondActivity(view: View) {
        val intent = Intent(this, MainActivity3::class.java)
        startActivity(intent)
    }

    fun goToThirdActivity(view: View) {
        val intent = Intent(this, MainActivity5::class.java)
        startActivity(intent)
    }
    fun goToFouthActivity(view: View) {
        val intent = Intent(this, MainActivity6::class.java)
        startActivity(intent)
    }
}
