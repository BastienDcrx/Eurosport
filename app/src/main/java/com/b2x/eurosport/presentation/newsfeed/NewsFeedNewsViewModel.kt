package com.b2x.eurosport.presentation.newsfeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.b2x.eurosport.presentation.mapper.VideoViewModelMapper
import com.b2x.eurosport.domain.interactors.GetNewsInteractor
import com.b2x.eurosport.domain.model.StoryEntity
import com.b2x.eurosport.domain.model.VideoEntity
import com.b2x.eurosport.presentation.common.BaseViewModel
import com.b2x.eurosport.presentation.mapper.StoryViewModelMapper
import com.b2x.eurosport.presentation.model.News
import com.b2x.eurosport.presentation.model.Resource

class NewsFeedNewsViewModel(
    val getNewsInteractor: GetNewsInteractor,
    val videoMapper: VideoViewModelMapper,
    val storyMapper: StoryViewModelMapper
) : BaseViewModel() {

    private val newsLiveData: MutableLiveData<Resource<List<News>>> = MutableLiveData()

    fun getNewsLiveData(): LiveData<Resource<List<News>>> {
        return newsLiveData
    }

    fun fetchNews() {
        newsLiveData.postValue(Resource.loading())
        addToDisposables(
            getNewsInteractor.execute()
                .map {
                    val news = arrayListOf<News>()
                    it.forEach { entity ->
                        news.add(
                            when (entity) {
                                is StoryEntity -> storyMapper.mapToViewModel(entity)
                                is VideoEntity -> videoMapper.mapToViewModel(entity)
                            }
                        )
                    }
                    news
                }
                .subscribe({
                    newsLiveData.postValue(
                        Resource.success(it)
                    )
                }, {
                    newsLiveData.postValue(
                        Resource.error(it.message)
                    )
                })
        )
    }
}
