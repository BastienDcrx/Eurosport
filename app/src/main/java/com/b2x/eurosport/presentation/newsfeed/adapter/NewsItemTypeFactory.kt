package com.b2x.eurosport.presentation.newsfeed.adapter

import android.view.View
import com.b2x.eurosport.presentation.model.Story
import com.b2x.eurosport.presentation.model.TypeVisitable
import com.b2x.eurosport.presentation.model.Video
import com.b2x.eurosport.presentation.newsfeed.adapter.viewholders.NewsViewHolder

interface NewsItemTypeFactory {

    fun getType(story: Story): Int

    fun getType(video: Video): Int

    fun createViewHolder(view: View, type: Int): NewsViewHolder<TypeVisitable>
}
