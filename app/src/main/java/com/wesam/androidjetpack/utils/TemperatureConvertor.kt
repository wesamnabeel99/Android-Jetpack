package com.wesam.androidjetpack.utils

import kotlin.math.roundToInt

object TemperatureConvertor {
    fun convertFahrenheitToCelsius (fahrenheit : String) = ((fahrenheit.toDouble() - 32) * 0.556)
        .roundToInt()
        .toString()
}

