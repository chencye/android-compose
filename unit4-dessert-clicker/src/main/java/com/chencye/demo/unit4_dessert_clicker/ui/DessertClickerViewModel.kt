package com.chencye.demo.unit4_dessert_clicker.ui

import androidx.lifecycle.ViewModel
import com.chencye.demo.unit4_dessert_clicker.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertClickerViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DessertClickerUiState())

    // 让外部可以访问，但不能修改
    val uiState: StateFlow<DessertClickerUiState> = _uiState.asStateFlow()

    fun onClicked() {
        _uiState.update { currentState ->
            val updatedSold = currentState.sold + 1;
            val nextDessertIndex = determineDessertIndex(updatedSold)
            currentState.copy(
                sold = updatedSold,
                revenue = currentState.revenue + currentState.currentPrice,
                currentIdx = nextDessertIndex,
                currentPrice = dessertList[nextDessertIndex].price,
                currentImageId = dessertList[nextDessertIndex].imageId,
            )
        }
    }

    private fun determineDessertIndex(updatedSold: Int): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (updatedSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else {
                break
            }
        }
        return dessertIndex
    }

}
