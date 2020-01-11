package com.b2x.eurosport.data.remote.model

import com.google.gson.annotations.SerializedName

data class NewsRemoteModel(

    @SerializedName("stories") val stories: List<StoryRemoteModel>,
    @SerializedName("videos") val videos: List<VideoRemoteModel>
)
