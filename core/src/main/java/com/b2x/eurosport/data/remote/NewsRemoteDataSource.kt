package com.b2x.eurosport.data.remote

import com.b2x.eurosport.data.NewsDataSource
import com.b2x.eurosport.data.remote.mapper.StoryRemoteMapper
import com.b2x.eurosport.data.remote.mapper.VideoRemoteMapper
import com.b2x.eurosport.domain.model.NewsEntity
import io.reactivex.Single

class NewsRemoteDataSource constructor(
    private val newsService: NewsService,
    private val storyRemoteMapper: StoryRemoteMapper,
    private val videoRemoteMapper: VideoRemoteMapper

) : NewsDataSource {

    override fun getNews(): Single<List<NewsEntity>> {
        return newsService.getNews()
            .map {
                val entities = mutableListOf<NewsEntity>()
                it.stories.forEach { story -> entities.add(storyRemoteMapper.mapToEntity(story)) }
                it.videos.forEach { video -> entities.add(videoRemoteMapper.mapToEntity(video)) }
                entities
            }
    }
}
