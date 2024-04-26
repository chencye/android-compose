package com.chencye.demo.unit4_dessert_clicker.ui

import androidx.annotation.DrawableRes
import com.chencye.demo.unit4_dessert_clicker.data.Datasource.dessertList

data class DessertClickerUiState(
    val sold: Int = 0,
    val revenue: Int = 0,
    val currentIdx: Int = 0,
    val currentPrice: Int = dessertList[currentIdx].price,
    @DrawableRes val currentImageId: Int = dessertList[currentIdx].imageId
)