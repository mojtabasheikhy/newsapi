package com.example.books_shop2.books

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.books_shop2.R
import com.example.books_shop2.adpter.my_custom_adapter
import com.example.books_shop2.data_model.my_data_book_shop
import com.example.books_shop2.retrofit.retrofit_callback
import kotlinx.android.synthetic.main.activity_books_list.*
lateinit var sharedPreferences:SharedPreferences
class books_list : AppCompatActivity(),retrofit_callback.data_recived {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_list)
        retrofit_callback().get_data(this)
        state()
    }

    override fun data_interface(mylist: ArrayList<my_data_book_shop>) {
        recycler_view_main.layoutManager=LinearLayoutManager(this)
        var adapter=my_custom_adapter(this,mylist)
        recycler_view_main.adapter=adapter


    }
    fun state(){
        sharedPreferences= getSharedPreferences("mypref", MODE_PRIVATE)
        var editor=sharedPreferences.edit()
        editor.putBoolean("second",true)
        editor.apply()
    }
}