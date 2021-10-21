package com.wesam.androidjetpack.viewModel

import androidx.lifecycle.*
import com.wesam.androidjetpack.extensions.convertToCelsius
import com.wesam.androidjetpack.extensions.changeTemperatureStateBasedOnCelsiusValue
import com.wesam.androidjetpack.utils.TemperatureState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    val fahrenheitTemperature = MutableStateFlow("")
    val celsiusTemperature = MutableStateFlow("")

    val temperatureState = MutableStateFlow(TemperatureState.DEFAULT)

    fun convertTemperature() {
        viewModelScope.launch {
            fahrenheitTemperature
                .convertToCelsius()
                .collect { celsius ->
                    celsiusTemperature.emit(celsius)
                    changeTemperatureState()
                }
        }
    }

     private suspend fun changeTemperatureState() {
         temperatureState.changeTemperatureStateBasedOnCelsiusValue(celsiusTemperature.value.toInt())
    }


}