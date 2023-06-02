package com.example.cankarademir_odev4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.cankarademir_odev4.adapter.NewsCostumAdapter
import com.example.cankarademir_odev4.services.Result


class MainActivity : AppCompatActivity() {

    lateinit var newslistView:ListView
    private val newsresult= Result()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newslistView= findViewById(R.id.newsListview)

        val run = Runnable {
            val newsResult = newsresult.news()
            val customAdapter = NewsCostumAdapter(this, newsResult)
            runOnUiThread {
                newslistView.adapter = customAdapter

                newslistView.setOnItemClickListener { adapterView, view, i, l ->
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("itemUrl", newsResult[i].href)
                    startActivity(intent)
                }
            }
        }
        Thread(run).start()
    }
}