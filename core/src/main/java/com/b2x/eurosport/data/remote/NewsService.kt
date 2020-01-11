package com.b2x.eurosport.data.remote

import com.b2x.eurosport.data.remote.model.NewsRemoteModel
import io.reactivex.Single
import retrofit2.http.GET

interface NewsService {

    @GET("ug7oc")
    fun getNews(): Single<NewsRemoteModel>
}
