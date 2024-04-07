package com.example.loginapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity16 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main16)

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true

        val url = "https://docs.google.com/presentation/d/1RHp6ve_hvYG_fkLigyB1jkM51PNJXfg4sIcFsBh9Ztw/edit?usp=sharing"
        webView.loadUrl(url)
        webView.webViewClient = WebViewClient()
    }
}
