package com.example.books_shop2.retrofit

import com.example.books_shop2.data_model.articles
import com.example.books_shop2.data_model.articles_main
import com.example.books_shop2.data_model.my_data_book_shop
import com.example.books_shop2.data_model.users
import retrofit2.Call
import retrofit2.http.*

interface retrofit_get_data {


    @GET("books.php")
    fun callback_data():Call<ArrayList<my_data_book_shop>>



    @POST("register.php")
    @FormUrlEncoded
    fun getuser(@Field("username") username:String,
                @Field("email")email:String,
                @Field("phone_number")phone_number:String,
                @Field("password")password:String)
                :Call<users>

    @POST("login.php")
    @FormUrlEncoded
    fun login_user(@Field ("username")username:String  , @Field("password")password: String):Call<users>


    @GET("top-headlines?country=us&category=business&apiKey=af6d2b075f414ac48536cbc203d28741")
    fun get_news_data():Call<articles_main>

}