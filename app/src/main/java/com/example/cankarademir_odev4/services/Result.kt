package com.example.cankarademir_odev4.services

import android.util.Log
import com.example.cankarademir_odev4.models.News
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class Result {

    fun news () : List<News>  {
        val list = mutableListOf<News>()
        val url = "https://www.haberler.com"
        val doc:Document = Jsoup.connect(url).timeout(15000).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36").get()
        val elements: Elements = doc.getElementsByAttribute("data-headlinenumber")
        for ( item in elements) {

            val img = item.getElementsByTag("img")

            val href = item.attr("abs:href")
            val src = img.attr("data-src")
            val title = img.attr("alt")

            if ( title != "" && href != "" && src != "" ) {
                val news = News(title, src, href)
                list.add(news)
            }

        }
        return list
    }
}