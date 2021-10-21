package com.wesam.androidjetpack.model

object Repository {
    private val temperatureConvertor = TemperatureConvertor()

    fun convertFahrenheitToCelsius(fahrenheit : String) =
        temperatureConvertor
            .convertFahrenheitToCelsius(fahrenheit)
}