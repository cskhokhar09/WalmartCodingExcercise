package com.csk.walmartcodingexercise.data.network

import com.csk.walmartcodingexercise.model.CountryInfo
import retrofit2.http.GET

interface CountryInfoApiService {

    @GET("peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    suspend fun fetchCountries(): List<CountryInfo>
}