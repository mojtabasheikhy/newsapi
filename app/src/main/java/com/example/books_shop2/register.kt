package com.example.books_shop2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.books_shop2.data_model.users
import com.example.books_shop2.retrofit.retrofit_builder
import com.example.books_shop2.retrofit.retrofit_get_data
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class register : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        cirRegisterButton.setOnClickListener(this)
        login_textview.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.cirRegisterButton ->{

                send_data()

            }
           R.id.login_textview ->
           {
               startActivity(Intent(this,login::class.java))
               overridePendingTransition(R.anim.slide_in_right,R.anim.stay)
           }


        }


    }


    fun send_data()
    {
        var txt_username:String=editTextusername.text.toString()
        var txt_email:String=editTextEmail.text.toString()
        var txt_password:String=editTextPassword.text.toString()
        var phone_number:String=editTextMobile.text.toString()
        if (txt_email==""||txt_username==""||txt_password==""||phone_number=="")
        {
            Toast.makeText(this,"لطفا تمام مفادیر را پر کنید",Toast.LENGTH_SHORT).show()
            return
        }
        else{
        var call_register=retrofit_builder().biulder().create(retrofit_get_data::class.java).getuser(txt_username,txt_email,phone_number,txt_password)
        call_register.enqueue(object :Callback<users>{
            override fun onResponse(call: Call<users>, response: Response<users>) {
                var respone=response.body()
                if (respone?.response.equals( "users_register_long_time_ago"))
                {
                    Toast.makeText(this@register,"کاریر با این شماره قبلا ثبت نام کرده است",Toast.LENGTH_SHORT).show()
                }
                else if(respone?.response.equals( "not_success"))
                {
                    Toast.makeText(this@register,"عملیات ثبت نام با مشکل مواجه شده است",Toast.LENGTH_SHORT).show()
                }
                else if(respone?.response.equals( "success"))
                {
                    Toast.makeText(this@register,"عملیات ثبت نام انجام شد",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<users>, t: Throwable) {
                Log.e("err","${t.message}")
                Toast.makeText(this@register,"${t.message}",Toast.LENGTH_SHORT).show()
            }
        })


        }
    }
}