package com.example.loginapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity18 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main18)

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true

        val url = "https://docs.google.com/presentation/d/1bkKa7qumDU-SRzePTZiwrEiEqBuP2dzWIHVTdWE7nvU/edit?usp=sharing"
        webView.loadUrl(url)
        webView.webViewClient = WebViewClient()
    }
}
