package com.example.youtubeapi.di

import com.example.youtubeapi.data.api_services.YouTubeApiService
import com.example.youtubeapi.data.repository.YouTubeRepository
import com.example.youtubeapi.ui.fragments.playlists.PlayListsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = listOf(
    networkModule,
    repositoryModule,
    viewModelModule
)