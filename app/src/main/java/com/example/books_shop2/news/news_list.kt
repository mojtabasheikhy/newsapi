package com.example.books_shop2.news

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.books_shop2.R
import com.example.books_shop2.adpter.news_adapter
import com.example.books_shop2.data_model.articles
import com.example.books_shop2.data_model.articles_main
import ir.tapsell.plus.TapsellPlus
import ir.tapsell.sdk.bannerads.TapsellBannerType
import ir.tapsell.sdk.bannerads.TapsellBannerView
import ir.tapsell.sdk.bannerads.TapsellBannerViewEventListener
import kotlinx.android.synthetic.main.activity_news_list.*


var TAPSELL_KEY = "gpjtrrtrlfatbjhmqqrqrgckboqftkshmttdmipngclekslqfdisdgmoimpiphclprlkbh"

class news_list : AppCompatActivity(), get_news_data_interface.getnewsdata_interface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        ads_tapsell()
        get_news_data_interface(this).get_news_data(this)



    }


   fun ads_tapsell() {
        TapsellPlus.initialize(this, TAPSELL_KEY)

        var banner = findViewById<TapsellBannerView>(R.id.banner)
        banner.loadAd(this, "600c173b8debc40001299243", TapsellBannerType.BANNER_320x50)
        banner.setEventListener(object : TapsellBannerViewEventListener {
            override fun onRequestFilled() {
                Toast.makeText(this@news_list, "سی", Toast.LENGTH_SHORT).show()

            }

            override fun onNoAdAvailable() {
                Toast.makeText(this@news_list, "سی", Toast.LENGTH_SHORT).show()
            }

            override fun onNoNetwork() {
                Toast.makeText(this@news_list, "سی", Toast.LENGTH_SHORT).show()
            }

            override fun onError(message: String) {
                Toast.makeText(this@news_list, "سی", Toast.LENGTH_SHORT).show()
            }

            override fun onHideBannerView() {
                Toast.makeText(this@news_list, "سی", Toast.LENGTH_SHORT).show()
            }
        })


    }

    override fun recived_news_data(data_give_back:articles_main) {
        progress_news.visibility=View.GONE
        progress_news_edt.visibility=View.GONE
        var data_give_back2=data_give_back
        var arrayList:ArrayList<articles> = data_give_back2.articles
        recycler_news.layoutManager = LinearLayoutManager(this)
        var adapter_news = news_adapter(this, arrayList)
        recycler_news.adapter = adapter_news
    }


}


