package com.example.youtubeapi.di

import com.example.youtubeapi.ui.fragments.playlists.PlayListsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.scope.get
import org.koin.dsl.module

val viewModelModule : Module = module {
    viewModel {
        PlayListsViewModel(get())
    }
}