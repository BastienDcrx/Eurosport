package com.b2x.eurosport.presentation.model

import com.b2x.eurosport.presentation.newsfeed.adapter.NewsItemTypeFactory

sealed class News : TypeVisitable {
    abstract val timestamp: Int
    abstract val title: String
    abstract val category: String
    abstract val image: String
}

data class Video(
    val url: String,
    val views: Int,
    override val timestamp: Int,
    override val title: String,
    override val category: String,
    override val image: String
) : News() {
    override fun type(typeFactory: NewsItemTypeFactory): Int {
        return typeFactory.getType(this)
    }
}

class Story(
    val intro: String,
    val content: String,
    val author: String,
    override val timestamp: Int,
    override val title: String,
    override val category: String,
    override val image: String
) : News() {
    override fun type(typeFactory: NewsItemTypeFactory): Int {
        return typeFactory.getType(this)
    }
}
