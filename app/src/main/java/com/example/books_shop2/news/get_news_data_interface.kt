package com.example.books_shop2.news

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.books_shop2.data_model.articles
import com.example.books_shop2.data_model.articles_main

import com.example.books_shop2.retrofit.retrofit_builder
import com.example.books_shop2.retrofit.retrofit_get_data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class get_news_data_interface(var context: Context) {
    fun get_news_data(list_data:getnewsdata_interface)
    {
        var obj_builder_news =
            retrofit_builder().biulder_news().create(retrofit_get_data::class.java).get_news_data()
        obj_builder_news.enqueue(object : Callback<articles_main> {
            override fun onResponse(
                call: Call<articles_main>,
                response: Response<articles_main>
            ) {
                var body = response.body()
                if(body != null) {
                    list_data.recived_news_data(body)
                }
                else{
                    Toast.makeText(context,"اطلاعات دریافت نشد",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<articles_main>, t: Throwable) {
                Log.e("error", "${t.message}")
            }
        })
    }

    interface getnewsdata_interface{
        fun recived_news_data(data_give_back:articles_main)
    }
}