package com.wesam.androidjetpack.adapters

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.wesam.androidjetpack.R
import com.wesam.androidjetpack.extensions.changeBackgroundColor
import com.wesam.androidjetpack.extensions.changeTextColor
import com.wesam.androidjetpack.extensions.getColor
import com.wesam.androidjetpack.utils.TemperatureState

@BindingAdapter (value = ["temperatureBackground"])
fun changeColorBasedOnTemperatureState(view : View, temperatureState : TemperatureState) {
    val color = view.getColor(temperatureState)
    view.changeBackgroundColor(color)
}

@BindingAdapter (value = ["tempratureTextColor"])
fun changeTextColorBasedOnTemperatureState (textView: TextView , temperatureState: TemperatureState) {
    val color = textView.getColor(temperatureState)
    textView.changeTextColor(color)
}