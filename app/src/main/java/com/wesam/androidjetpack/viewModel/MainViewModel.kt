package com.wesam.androidjetpack.viewModel

import androidx.lifecycle.*
import com.wesam.androidjetpack.extensions.convertToCelsius
import com.wesam.androidjetpack.utils.TemperatureRange
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

            when (celsiusTemperature.value.toInt()) {

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