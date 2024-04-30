package com.chencye.demo.unit5_mars_photos.data

import com.chencye.demo.unit5_mars_photos.model.MarsPhoto
import com.chencye.demo.unit5_mars_photos.network.MarsApiService

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return marsApiService.getPhotos()
    }
}