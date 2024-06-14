package com.example.youtubeapi.app

import android.app.Application
import com.example.youtubeapi.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YouTubeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@YouTubeApp)
            modules(appModule)
        }
    }

}