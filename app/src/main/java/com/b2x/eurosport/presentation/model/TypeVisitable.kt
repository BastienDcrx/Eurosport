package com.b2x.eurosport.presentation.model

import com.b2x.eurosport.presentation.newsfeed.adapter.NewsItemTypeFactory

interface TypeVisitable {
    fun type(typeFactory: NewsItemTypeFactory): Int
}
