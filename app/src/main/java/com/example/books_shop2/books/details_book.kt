package com.example.books_shop2.books

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.books_shop2.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details_book.*
import kotlinx.android.synthetic.main.list_item.*

class details_book : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_book)
        get_extra()
    }
    @SuppressLint("SetTextI18n")
    fun get_extra()
    {
        var get_data_from_main = intent
        text_name_book.text="نام کتاب : "+get_data_from_main.getStringExtra("name_of_book")
        text_description.text = " توضیحات : " +get_data_from_main.getStringExtra("name_description")
        Picasso.get().load(get_data_from_main.getStringExtra("link_img")).into(image_detail)
    }
}