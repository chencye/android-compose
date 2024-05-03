
package com.chencye.demo.android.unit6_inventory_app.ui.home

import androidx.lifecycle.ViewModel
import com.chencye.demo.android.unit6_inventory_app.data.Item

/**
 * ViewModel to retrieve all items in the Room database.
 */
class HomeViewModel : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * Ui State for HomeScreen
 */
data class HomeUiState(val itemList: List<Item> = listOf())
