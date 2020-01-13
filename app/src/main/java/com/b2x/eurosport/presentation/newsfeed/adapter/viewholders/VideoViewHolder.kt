package com.b2x.eurosport.presentation.newsfeed.adapter.viewholders

import android.view.View
import androidx.annotation.LayoutRes
import com.b2x.eurosport.R
import com.b2x.eurosport.presentation.model.Video
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news_video.*

class VideoViewHolder constructor(itemView: View) : NewsViewHolder<Video>(itemView) {

    companion object {
        @LayoutRes
        const val LAYOUT_ID = R.layout.item_news_video
    }

    private val imageIv get() = image_view_item_news_video_content
    private val titleTv get() = text_view_item_news_video_title
    private val categoryTv get() = text_view_item_news_video_tag
    private val viewCountTv get() = text_view_item_news_video_views_count

    override fun bindView(item: Video) {
        categoryTv.text = item.category
        titleTv.text = item.title
        viewCountTv.text = itemView.context.getString(R.string.video_views_count, item.views)

        Glide.with(itemView.context)
            .load(item.image)
            .into(imageIv)
    }
}
