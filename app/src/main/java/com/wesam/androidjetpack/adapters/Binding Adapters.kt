package com.wesam.androidjetpack.adapters

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.wesam.androidjetpack.R
import com.wesam.androidjetpack.extensions.changeBackgroundColor
import com.wesam.androidjetpack.extensions.changeTextColor
import com.wesam.androidjetpack.utils.TemperatureState

//TODO : reduce duplication
@BindingAdapter (value = ["temperatureBackground"])
fun changeColorBasedOnTemperatureState(view : View, temperatureState : TemperatureState) {
    when (temperatureState) {
        TemperatureState.VERY_COLD -> view.changeBackgroundColor(R.color.blue)
        TemperatureState.COLD -> view.changeBackgroundColor(R.color.green)
        TemperatureState.NORMAL -> view.changeBackgroundColor(R.color.yellow)
        TemperatureState.HOT -> view.changeBackgroundColor(R.color.orange)
        TemperatureState.VERY_HOT -> view.changeBackgroundColor(R.color.red)
        TemperatureState.DEFAULT -> view.changeBackgroundColor(R.color.black)
    }
}

@BindingAdapter (value = ["tempratureTextColor"])
fun changeTextColorBasedOnTemperatureState (textView: TextView , temperatureState: TemperatureState) {
    when (temperatureState) {
        TemperatureState.VERY_COLD -> textView.changeTextColor(R.color.blue)
        TemperatureState.COLD -> textView.changeTextColor(R.color.green)
        TemperatureState.NORMAL -> textView.changeTextColor(R.color.yellow)
        TemperatureState.HOT -> textView.changeTextColor(R.color.orange)
        TemperatureState.VERY_HOT -> textView.changeTextColor(R.color.red)
        TemperatureState.DEFAULT -> textView.changeTextColor(R.color.black)
    }
}