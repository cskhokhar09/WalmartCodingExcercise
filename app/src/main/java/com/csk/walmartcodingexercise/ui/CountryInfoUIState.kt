package com.csk.walmartcodingexercise.ui

import com.csk.walmartcodingexercise.model.CountryInfo

sealed interface CountryInfoUIState{
    data class Success(val countryInfo: List<CountryInfo>): CountryInfoUIState
    data object Loading: CountryInfoUIState
    data object Error: CountryInfoUIState
}
