package com.example.books_shop2

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.books_shop2.books.books_list
import com.example.books_shop2.books.sharedPreferences
import com.example.books_shop2.data_model.users
import com.example.books_shop2.retrofit.retrofit_builder
import com.example.books_shop2.retrofit.retrofit_get_data

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class login : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    fun init()
    {
        text_to_register.setOnClickListener(this)
        cirLoginButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            text_to_register.id ->
            {
                startActivity(Intent(this,register::class.java))
                overridePendingTransition(R.anim.slide_in_left,R.anim.stay)


            }

            cirLoginButton.id -> {

                log_in()
            }
        }
    }
    fun log_in()
    {
        var text_username=editTextusername_login.text.toString()
        var text_password=editTextPassword_login.text.toString()
        if (text_password==""||text_username==""){
            Toast.makeText(this,"لطفا فیلد نام کاربری و رمز عبور را وارد کنید",Toast.LENGTH_SHORT).show()
            return
        }
        else
        {

            var call2=retrofit_builder().biulder().create(retrofit_get_data::class.java).login_user(text_username,text_password)
            call2.enqueue(object :Callback<users>{
                override fun onResponse(call: Call<users>, response: Response<users>) {
                    var response2=response.body()
                    if (response2==null)
                    {
                        Toast.makeText(this@login,"wrong",Toast.LENGTH_SHORT).show()
                    }
                    else if (response2!!.response.equals("users_true"))
                    {
                        startActivity(Intent(this@login,books_list::class.java))

                        finish()

                    }
                    else if (response2.response.equals("no_acount")) {
                        Toast.makeText(this@login,"اطلاعات ورودی اشتباه است",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Log.e("er","sd")
                    }
                }

                override fun onFailure(call: Call<users>, t: Throwable) {
                    Log.e("er","${t.message}")
                    Toast.makeText(this@login,"اطلاعاتی از سمت سرور  یافت نشد ",Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
    fun state()
    {
             sharedPreferences=getSharedPreferences("mypref", MODE_PRIVATE)
        if (sharedPreferences.getBoolean("second",false)){
            startActivity(Intent(this,books_list::class.java))
            finish()
        }
    }

}
