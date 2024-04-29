package com.chencye.demo.unit5_mars_photos.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chencye.demo.unit5_mars_photos.network.MarsApi
import kotlinx.coroutines.launch
import java.io.IOException

class MarsViewModel : ViewModel() {
    sealed interface MarsUiState {
        data class Success(val photos: String) : MarsUiState
        object Error : MarsUiState
        object Loading : MarsUiState
    }

    /** The mutable State that stores the status of the most recent request */
    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getMarsPhotos() {
        viewModelScope.launch {
            marsUiState = try {
                val listResult = MarsApi.retrofitService.getPhotos()
                MarsUiState.Success(listResult)
            } catch (e: IOException) {
                Log.e("getMarsPhotos", "${e.message}")
                MarsUiState.Error
            }
        }
    }
}
