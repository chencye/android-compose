package com.chencye.demo.unit5_mars_photos.network

import com.chencye.demo.unit5_mars_photos.model.MarsPhoto
import retrofit2.http.GET

interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
