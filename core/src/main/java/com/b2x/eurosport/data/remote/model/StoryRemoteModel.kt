package com.b2x.eurosport.data.remote.model

import com.google.gson.annotations.SerializedName

data class StoryRemoteModel(

    @SerializedName("timestamp") val timestamp: Int,
    @SerializedName("title") val title: String,
    @SerializedName("intro") val intro: String,
    @SerializedName("content") val content: String,
    @SerializedName("image") val image: String,
    @SerializedName("category") val category: String,
    @SerializedName("author") val author: String
)
