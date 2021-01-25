package com.example.books_shop2.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.books_shop2.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_activity.*
import kotlinx.android.synthetic.main.activity_details_book.*

class detail_activity_news : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_activity)
        get_data_extra_detail_news()
    }

    fun get_data_extra_detail_news() {
        var intent = intent
        val content = intent.getStringExtra("content")
        val title = intent.getStringExtra("title")
        val description=intent.getStringExtra("description")
        val author=intent.getStringExtra("author")
        var publishedat=intent.getStringExtra("published at")
        Picasso.get().load(intent.getStringExtra("image")).into(detail_image_view)


        title_news_detail.text=title
        text_detail_desc.text=description
        text_detail_content.text = content
        text_detail_author.text=author
        text_detail_published_at.text=publishedat
    }
}