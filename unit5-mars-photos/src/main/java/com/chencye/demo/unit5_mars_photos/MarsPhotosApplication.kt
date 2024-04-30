package com.chencye.demo.unit5_mars_photos

import android.app.Application
import com.chencye.demo.unit5_mars_photos.data.AppContainer
import com.chencye.demo.unit5_mars_photos.data.DefaultAppContainer

class MarsPhotosApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}