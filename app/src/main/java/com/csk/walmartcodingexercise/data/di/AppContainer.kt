package com.csk.walmartcodingexercise.data.di

import com.csk.walmartcodingexercise.data.network.CountryInfoApiService
import com.csk.walmartcodingexercise.data.repo.CountryInfoRepository
import com.csk.walmartcodingexercise.data.repo.CountryInfoRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val countryInfoRepo: CountryInfoRepository
}

class DefaultAppContainer : AppContainer {

    private val baseUrl = "https://gist.githubusercontent.com/"

    private val retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    private val apiService: CountryInfoApiService by lazy {
        retrofit.create(CountryInfoApiService::class.java)
    }

    override val countryInfoRepo: CountryInfoRepository
        get() = CountryInfoRepositoryImpl(apiService)
}