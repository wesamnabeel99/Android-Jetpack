package com.wesam.androidjetpack.utils

object TemperatureRange {
     val VERY_COLD_RANGE = Int.MIN_VALUE until 0
     val COLD_RANGE = 0 until 21
     val NORMAL_RANGE = 21 until 31
     val HOT_RANGE = 31 until 41
     val VERY_HOT_RANGE = 40..Int.MAX_VALUE
}