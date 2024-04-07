package com.example.loginapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity17 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main17)

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true

        val url = "https://docs.google.com/presentation/d/1uLLFXICdlZyQhu4VwjbzgW3mqVP1zsJp7VSTya_1U7Y/edit?usp=sharing"
        webView.loadUrl(url)
        webView.webViewClient = WebViewClient()
    }
}
