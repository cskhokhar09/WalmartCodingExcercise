package com.csk.walmartcodingexercise

import android.app.Application
import com.csk.walmartcodingexercise.data.di.AppContainer
import com.csk.walmartcodingexercise.data.di.DefaultAppContainer

class MyApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}