package com.wesam.androidjetpack.extensions

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.wesam.androidjetpack.R
import com.wesam.androidjetpack.model.Repository
import com.wesam.androidjetpack.utils.TemperatureRange
import com.wesam.androidjetpack.utils.TemperatureState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

fun View.getColor (temperatureState : TemperatureState)  = when (temperatureState) {
    TemperatureState.VERY_COLD ->  ContextCompat.getColor(this.context, R.color.blue)
    TemperatureState.COLD -> ContextCompat.getColor(this.context, R.color.green)
    TemperatureState.NORMAL -> ContextCompat.getColor(this.context, R.color.yellow)
    TemperatureState.HOT -> ContextCompat.getColor(this.context, R.color.orange)
    TemperatureState.VERY_HOT -> ContextCompat.getColor(this.context, R.color.red)
    TemperatureState.DEFAULT -> ContextCompat.getColor(this.context, R.color.black)
}
fun View.changeBackgroundColor(color: Int) {
    this.setBackgroundColor(color)
}
fun TextView.changeTextColor (color:Int) {
    this.setTextColor(color)
}

suspend fun MutableStateFlow<TemperatureState>.changeTemperatureStateBasedOnCelsiusValue(celsiusTemperature :Int) {
    when (celsiusTemperature) {
        in TemperatureRange.VERY_COLD_RANGE -> {
            this.emit(TemperatureState.VERY_COLD)
        }
        in TemperatureRange.COLD_RANGE -> {
            this.emit(TemperatureState.COLD)
        }
        in TemperatureRange.NORMAL_RANGE -> {
            this.emit(TemperatureState.NORMAL)
        }
        in TemperatureRange.HOT_RANGE -> {
            this.emit(TemperatureState.HOT)
        }
        in TemperatureRange.VERY_HOT_RANGE -> {
            this.emit(TemperatureState.VERY_HOT)
        }
    }

}

//TODO : encapsulate the function to temperatureInFahrenheit variable only
fun MutableStateFlow<String>.convertToCelsius() : Flow<String> {
    return this
        .filter { fahrenheitTemperature ->
            fahrenheitTemperature.isNotEmpty()
        }
        .map { fahrenheitTemperature ->
            Repository.convertFahrenheitToCelsius(fahrenheitTemperature)
        }
}


