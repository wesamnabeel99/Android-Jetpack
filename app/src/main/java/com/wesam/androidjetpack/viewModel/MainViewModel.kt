package com.wesam.androidjetpack.viewModel

import androidx.lifecycle.*
import com.wesam.androidjetpack.extensions.convertToCelsius
import com.wesam.androidjetpack.extensions.changeTemperatureStateBasedOnCelsiusValue
import com.wesam.androidjetpack.utils.TemperatureState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    val fahrenheit = MutableStateFlow("")
    private val _celsius = MutableStateFlow("")
    val celsius : StateFlow<String>
        get() = _celsius
    private val _temperatureState = MutableStateFlow(TemperatureState.DEFAULT)
    val temperatureState : StateFlow<TemperatureState>
        get() = _temperatureState

    fun convertTemperature() {
        viewModelScope.launch {
            fahrenheit
                .convertToCelsius()
                .collect { convertedTemperature ->
                    _celsius.emit(convertedTemperature)
                    changeTemperatureState()
                }
        }
    }
    private suspend fun changeTemperatureState() {
        _temperatureState.changeTemperatureStateBasedOnCelsiusValue(celsius.value.toInt())
    }
}