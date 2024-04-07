package com.example.loginapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity15 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main15)

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true

        val url = "https://docs.google.com/presentation/d/1tmsO5aV0_8a3asZQyzM-O1U1dt1DqBj77tb_iihQGk0/edit?usp=sharing"
        webView.loadUrl(url)
        webView.webViewClient = WebViewClient()
    }
}
