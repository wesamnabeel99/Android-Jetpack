package com.wesam.androidjetpack.model

import kotlin.math.roundToInt

class TemperatureConvertor {
    fun convertFahrenheitToCelsius (fahrenheit : String) =
        ( (fahrenheit.toDouble() - 32) * 0.556 )
            .roundToInt()
            .toString()
}

