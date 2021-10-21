package com.wesam.androidjetpack.viewModel

import androidx.lifecycle.*
import com.wesam.androidjetpack.extensions.convertToCelsius
import com.wesam.androidjetpack.utils.TemperatureRange
import com.wesam.androidjetpack.utils.TemperatureState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    val temperatureInFahrenheit = MutableStateFlow("32")
    val temperatureInCelsius = MutableStateFlow("0")

    val temperatureState = MutableStateFlow(TemperatureState.DEFAULT)

    fun updateCelsius() {
        viewModelScope.launch {
            temperatureInFahrenheit
                .convertToCelsius()
                .collect { celsius ->
                    temperatureInCelsius.emit(celsius)
                    changeTemperatureState()
                }
        }
    }


     private suspend fun changeTemperatureState() {

            when (temperatureInCelsius.value.toInt()) {

                in TemperatureRange.VERY_COLD_RANGE -> {
                    temperatureState.emit(TemperatureState.VERY_COLD)
                }
                in TemperatureRange.COLD_RANGE -> {
                    temperatureState.emit(TemperatureState.COLD)
                }
                in TemperatureRange.NORMAL_RANGE -> {
                    temperatureState.emit(TemperatureState.NORMAL)
                }
                in TemperatureRange.HOT_RANGE -> {
                    temperatureState.emit(TemperatureState.HOT)
                }
                in TemperatureRange.VERY_HOT_RANGE -> {
                    temperatureState.emit(TemperatureState.VERY_HOT)
                }

            }

    }


}