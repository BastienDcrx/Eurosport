package com.b2x.eurosport.presentation.newsfeed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b2x.eurosport.presentation.model.TypeVisitable
import com.b2x.eurosport.presentation.newsfeed.adapter.viewholders.NewsViewHolder

class NewsAdapter(
    val typeFactory: NewsItemTypeFactory
) : RecyclerView.Adapter<NewsViewHolder<TypeVisitable>>() {

    var newsList: List<TypeVisitable> = arrayListOf()

    override fun getItemViewType(position: Int): Int {
        val currentNews = newsList[position]

        return currentNews.type(typeFactory)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsViewHolder<TypeVisitable> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)

        return typeFactory.createViewHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: NewsViewHolder<TypeVisitable>, position: Int) {
        val currentNews = newsList[position]

        holder.bindView(currentNews)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun setData(news: List<TypeVisitable>) {
        newsList = news
        notifyDataSetChanged()
    }
}
