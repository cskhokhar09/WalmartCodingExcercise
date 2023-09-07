package com.csk.walmartcodingexercise.data.repo

import com.csk.walmartcodingexercise.model.CountryInfo

interface CountryInfoRepository {

    suspend fun fetchCountries() : List<CountryInfo>
}