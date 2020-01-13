package com.b2x.eurosport.presentation.newsfeed.adapter

import android.view.View
import com.b2x.eurosport.presentation.error.UnsupportedViewTypeException
import com.b2x.eurosport.presentation.model.Story
import com.b2x.eurosport.presentation.model.TypeVisitable
import com.b2x.eurosport.presentation.model.Video
import com.b2x.eurosport.presentation.newsfeed.adapter.viewholders.NewsViewHolder
import com.b2x.eurosport.presentation.newsfeed.adapter.viewholders.StoryViewHolder
import com.b2x.eurosport.presentation.newsfeed.adapter.viewholders.VideoViewHolder

class NewsItemTypeFactoryImpl : NewsItemTypeFactory {

    override fun getType(story: Story): Int = StoryViewHolder.LAYOUT_ID

    override fun getType(video: Video): Int = VideoViewHolder.LAYOUT_ID

    override fun createViewHolder(view: View, type: Int): NewsViewHolder<TypeVisitable> {
        return when (type) {
            StoryViewHolder.LAYOUT_ID -> StoryViewHolder(view) as NewsViewHolder<TypeVisitable>
            VideoViewHolder.LAYOUT_ID -> VideoViewHolder(view) as NewsViewHolder<TypeVisitable>
            else -> throw UnsupportedViewTypeException(
                type.toString()
            )
        }
    }
}
