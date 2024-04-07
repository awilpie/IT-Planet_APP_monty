package com.example.loginapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity12 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true

        val url = "https://docs.google.com/presentation/d/1H-2WjnAPE4CSf-50X3sFo2ybvalaASfN_VSOrshPjtU/edit?usp=sharing"
        webView.loadUrl(url)
        webView.webViewClient = WebViewClient()
    }
}
