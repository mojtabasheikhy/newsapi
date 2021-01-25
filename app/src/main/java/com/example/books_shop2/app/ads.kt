package com.example.books_shop2.app

import android.app.Application
import android.content.Context
import android.view.View
import android.widget.Toast
import ir.tapsell.sdk.Tapsell

import com.example.books_shop2.R
import com.example.books_shop2.news.TAPSELL_KEY
import ir.tapsell.plus.TapsellPlus
import ir.tapsell.sdk.bannerads.TapsellBannerType
import ir.tapsell.sdk.bannerads.TapsellBannerView
import ir.tapsell.sdk.bannerads.TapsellBannerViewEventListener

class ads:Application() {
    override fun onCreate() {
        super.onCreate()
          Tapsell.initialize(this, TAPSELL_KEY)
    }
}