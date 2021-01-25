package com.example.books_shop2.adpter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.books_shop2.R
import com.example.books_shop2.data_model.articles
import com.example.books_shop2.news.detail_activity_news
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_list_item.view.*

class news_adapter(var context: Context, var list: ArrayList<articles>) :
    RecyclerView.Adapter<news_adapter.my_view_holder2>() {
    inner class my_view_holder2(item: View) : RecyclerView.ViewHolder(item) {
        var image_news = item.findViewById<ImageView>(R.id.image_news_list)
        var sourve_name = item.findViewById<TextView>(R.id.source_news_name)
        var description = item.findViewById<TextView>(R.id.description_news)
        var title_news = item.findViewById<TextView>(R.id.title_news)
        var publishedat = item.findViewById<TextView>(R.id.publisedat_news)
        var main_card=item.findViewById<CardView>(R.id.main_cardview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): my_view_holder2 {
        return my_view_holder2(LayoutInflater.from(context).inflate(R.layout.news_list_item, null))
    }

    override fun onBindViewHolder(holder: my_view_holder2, position: Int) {
        Picasso.get().load(list[position].urlToImage).into(holder.image_news)
        holder.sourve_name.text = list[position].author
        holder.description.text = list[position].description
        holder.title_news.text = list[position].title
        holder.publishedat.text = list[position].publishedAt
        holder.main_card.setOnClickListener{

            click_onitem(holder,position)
        }
    }

    override fun getItemCount(): Int = list.size
    fun click_onitem(holder: my_view_holder2,position: Int)
    {
        var intent=Intent(context,detail_activity_news::class.java)
        intent.putExtra("content",list[position].content)
        intent.putExtra("description",list[position].description)

        intent.putExtra("image",list[position].urlToImage)
        intent.putExtra("author",list[position].author)
        intent.putExtra("published at",list[position].publishedAt)
        intent.putExtra("title",list[position].title)
        context.startActivity(intent)

    }
}