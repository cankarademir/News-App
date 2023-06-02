package com.example.cankarademir_odev4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class DetailActivity : AppCompatActivity() {
   lateinit var projectWebwiew:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val url = intent.getStringExtra("itemUrl");
        projectWebwiew =findViewById(R.id.newsListview)
        projectWebwiew.settings.javaScriptEnabled = true
        projectWebwiew.loadUrl(url!!)
    }
}