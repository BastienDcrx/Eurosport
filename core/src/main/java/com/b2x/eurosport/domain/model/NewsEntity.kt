package com.b2x.eurosport.domain.model

sealed class NewsEntity {
    abstract val timestamp: Int
    abstract val title: String
    abstract val category: String
    abstract val image: String
}

data class VideoEntity(
    val url: String,
    val views: Int,
    override val timestamp: Int,
    override val title: String,
    override val category: String,
    override val image: String
) : NewsEntity()

data class StoryEntity(
    val intro: String,
    val content: String,
    val author: String,
    override val timestamp: Int,
    override val title: String,
    override val category: String,
    override val image: String
) : NewsEntity()
