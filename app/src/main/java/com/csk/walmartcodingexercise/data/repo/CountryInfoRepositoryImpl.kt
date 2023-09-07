package com.csk.walmartcodingexercise.data.repo

import com.csk.walmartcodingexercise.data.network.CountryInfoApiService
import com.csk.walmartcodingexercise.model.CountryInfo

class CountryInfoRepositoryImpl(private val apiService: CountryInfoApiService): CountryInfoRepository {

    override suspend fun fetchCountries(): List<CountryInfo> = apiService.fetchCountries()
}