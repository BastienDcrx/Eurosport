package com.b2x.eurosport.presentation.newsfeed.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.b2x.eurosport.presentation.model.TypeVisitable
import kotlinx.android.extensions.LayoutContainer

abstract class NewsViewHolder<T : TypeVisitable>(itemView: View) :
    RecyclerView.ViewHolder(itemView),
    LayoutContainer {

    override val containerView: View?
        get() = itemView

    abstract fun bindView(item: T)
}
