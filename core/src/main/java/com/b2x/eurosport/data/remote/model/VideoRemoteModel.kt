package com.b2x.eurosport.data.remote.model

import com.google.gson.annotations.SerializedName

data class VideoRemoteModel(

    @SerializedName("timestamp") val timestamp: Int,
    @SerializedName("title") val title: String,
    @SerializedName("image") val image: String,
    @SerializedName("url") val url: String,
    @SerializedName("category") val category: String,
    @SerializedName("views") val views: Int
)
