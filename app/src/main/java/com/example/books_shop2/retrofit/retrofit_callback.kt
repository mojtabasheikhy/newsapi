package com.example.books_shop2.retrofit

import android.util.Log
import com.example.books_shop2.data_model.my_data_book_shop
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class retrofit_callback {
    var call_data=retrofit_builder().biulder().create(retrofit_get_data::class.java)
    fun get_data(dataRecived: data_recived){

        var call=call_data.callback_data()
        call.enqueue(object :Callback<ArrayList<my_data_book_shop>>{
            override fun onResponse(
                call: Call<ArrayList<my_data_book_shop>>,
                response: Response<ArrayList<my_data_book_shop>>
            ) {
               var data_response=response.body()
                if (data_response!=null){
                dataRecived.data_interface(data_response)}

            }

            override fun onFailure(call: Call<ArrayList<my_data_book_shop>>, t: Throwable) {
              Log.e("erro","${t.message}")
            }
        })
    }

    interface data_recived
    {
        fun data_interface(mylist:ArrayList<my_data_book_shop>)
    }
}