package com.wesam.androidjetpack.extensions

import android.view.View
import androidx.core.content.ContextCompat
import com.wesam.androidjetpack.utils.TemperatureConvertor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

fun View.changeBackgroundColor(id: Int) {
    this.setBackgroundColor(ContextCompat.getColor(this.context , id))
}
fun MutableStateFlow<String>.convertToCelsius() = this
        .filter { fahrenheit -> fahrenheit.isNotEmpty() }
        .map { fahrenheit -> TemperatureConvertor.convertFahrenheitToCelsius(fahrenheit) }
