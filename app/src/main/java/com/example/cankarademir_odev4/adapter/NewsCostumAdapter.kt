package com.example.cankarademir_odev4.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.cankarademir_odev4.R
import com.example.cankarademir_odev4.models.News

class NewsCostumAdapter(private val context: Activity, private val list: List<News>) : ArrayAdapter<News>(context,R.layout.costum_listview, list ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.costum_listview, null, true)

        val r_title = rootView.findViewById<TextView>(R.id.txtTitle)
        val r_image = rootView.findViewById<ImageView>(R.id.imgNews)

        val news = list.get(position)
        r_title.text= news.title

        Glide.with(rootView).load(news.img).into(r_image)
        return rootView
    }
}