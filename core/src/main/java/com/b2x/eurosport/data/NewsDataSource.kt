package com.b2x.eurosport.data

import com.b2x.eurosport.domain.model.NewsEntity
import io.reactivex.Single

interface NewsDataSource {

    fun getNews(): Single<List<NewsEntity>>
}
