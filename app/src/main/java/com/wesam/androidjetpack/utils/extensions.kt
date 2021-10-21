package com.wesam.androidjetpack.extensions

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.wesam.androidjetpack.utils.TemperatureConvertor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

fun View.changeBackgroundColor(colorId: Int) {
    this.setBackgroundColor(ContextCompat.getColor(this.context , colorId))
}
fun TextView.changeTextColor (colorId:Int) {
    this.setTextColor(ContextCompat.getColor(this.context,colorId))
}

fun MutableStateFlow<String>.convertToCelsius() = this
        .filter { fahrenheit -> fahrenheit.isNotEmpty() }
        .map { fahrenheit -> TemperatureConvertor.convertFahrenheitToCelsius(fahrenheit) }
