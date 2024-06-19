package com.example.youtubeapi.ui.fragments.playlists_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.youtubeapi.data.model.BaseResponse
import com.example.youtubeapi.data.model.Item
import com.example.youtubeapi.data.repository.YouTubeRepository
import retrofit2.Response

class PlaylistDetailViewModel(
    private val repository: YouTubeRepository
) : ViewModel() {

   fun getVideo(): Response<BaseResponse> {
        return repository.getVideos()
    }
}