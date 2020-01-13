package com.b2x.eurosport.presentation.newsfeed.adapter.viewholders

import android.view.View
import androidx.annotation.LayoutRes
import com.b2x.eurosport.R
import com.b2x.eurosport.presentation.model.Story
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news_story.*

class StoryViewHolder constructor(itemView: View) : NewsViewHolder<Story>(itemView) {

    companion object {
        @LayoutRes
        const val LAYOUT_ID = R.layout.item_news_story
    }

    private val imageIv get() = image_view_item_news_story_content
    private val titleTv get() = text_view_item_news_story_title
    private val categoryTv get() = text_view_item_news_story_tag
    private val infoTv get() = text_view_item_news_story_info

    override fun bindView(item: Story) {
        with(item) {
            categoryTv.text = category
            titleTv.text = title
            infoTv.text = itemView.context.getString(
                R.string.story_info, item.author, item.timestamp.toString()
            )

            Glide.with(itemView.context)
                .load(image)
                .into(imageIv)
        }
    }
}
