package com.chencye.demo.unit3_courses

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val title: Int,
    val amount: Int,
    @DrawableRes val pic: Int
)
