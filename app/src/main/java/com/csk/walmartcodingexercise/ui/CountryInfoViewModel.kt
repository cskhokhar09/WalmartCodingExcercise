package com.csk.walmartcodingexercise.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.csk.walmartcodingexercise.MyApplication
import com.csk.walmartcodingexercise.data.repo.CountryInfoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException

class CountryInfoViewModel(
    private val countryInfoRepo: CountryInfoRepository
): ViewModel() {

    private var _countryInfoUiState = MutableStateFlow<CountryInfoUIState>(CountryInfoUIState.Loading)
    val countryInfoUiState : StateFlow<CountryInfoUIState> = _countryInfoUiState

    init {
        fetchCountryInfo()
    }

    private fun fetchCountryInfo() = viewModelScope.launch {
        try {
            val result = countryInfoRepo.fetchCountries()
            _countryInfoUiState.value = CountryInfoUIState.Success(result)
        } catch (ioException: IOException) {
            _countryInfoUiState.value = CountryInfoUIState.Error
        } catch (exception: Exception) {
            _countryInfoUiState.value = CountryInfoUIState.Error
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val countryInfoRepo = application.container.countryInfoRepo
                CountryInfoViewModel(countryInfoRepo = countryInfoRepo)
            }
        }
    }
}




