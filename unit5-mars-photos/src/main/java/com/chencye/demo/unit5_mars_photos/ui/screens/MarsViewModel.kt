package com.chencye.demo.unit5_mars_photos.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.chencye.demo.unit5_mars_photos.MarsPhotosApplication
import com.chencye.demo.unit5_mars_photos.data.MarsPhotosRepository
import com.chencye.demo.unit5_mars_photos.model.MarsPhoto
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface MarsUiState {
    data class Success(val photos: List<MarsPhoto>) : MarsUiState
    object Error : MarsUiState
    object Loading : MarsUiState
}

class MarsViewModel(private val marsPhotosRepository: MarsPhotosRepository) : ViewModel() {

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
                val listResult = marsPhotosRepository.getMarsPhotos()
                MarsUiState.Success(listResult)
            } catch (e: IOException) {
                Log.e("getMarsPhotos", "IOException: ${e.message}")
                MarsUiState.Error
            } catch (e: HttpException) {
                Log.e("getMarsPhotos", "HttpException: ${e.message}")
                MarsUiState.Error
            }
        }
    }

    // 因为 Android 框架不允许 ViewModel 在创建时在构造函数中传递值
    // 所以实现 ViewModelProvider.Factory 对象，以绕过这个限制。
    // 伴生对象通过拥有每个人都可以使用的单个对象实例，而无需创建昂贵对象的新实例
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MarsPhotosApplication)
                val marsPhotosRepository = application.container.marsPhotosRepository
                MarsViewModel(marsPhotosRepository = marsPhotosRepository)
            }
        }
    }
}
