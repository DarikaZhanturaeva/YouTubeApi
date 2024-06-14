package com.example.youtubeapi.data.model.thumbnails


import com.google.gson.annotations.SerializedName

data class Maxres(
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int
)