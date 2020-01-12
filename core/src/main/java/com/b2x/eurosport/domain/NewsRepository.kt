package com.b2x.eurosport.domain

import com.b2x.eurosport.domain.model.NewsEntity
import io.reactivex.Single

interface NewsRepository {

    fun getNews(): Single<List<NewsEntity>>
}
