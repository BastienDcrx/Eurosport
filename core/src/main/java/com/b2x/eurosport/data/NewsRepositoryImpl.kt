package com.b2x.eurosport.data

import com.b2x.eurosport.domain.model.NewsEntity
import com.b2x.eurosport.data.remote.NewsRemoteDataSource
import com.b2x.eurosport.domain.NewsRepository
import io.reactivex.Single

class NewsRepositoryImpl(private val remoteDataSource: NewsRemoteDataSource) : NewsRepository {

    override fun getNews(): Single<List<NewsEntity>> {
        return remoteDataSource.getNews()
    }
}
