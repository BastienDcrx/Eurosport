package com.b2x.eurosport.domain.interactors

import com.b2x.eurosport.domain.NewsRepository
import com.b2x.eurosport.domain.model.NewsEntity
import io.reactivex.Scheduler
import io.reactivex.Single

class GetNewsInteractor(
    val newsRepository: NewsRepository,
    subscribeScheduler: Scheduler,
    observeScheduler: Scheduler
) : BaseSingleInteractor<List<NewsEntity>, Unit?>(subscribeScheduler, observeScheduler) {

    override fun provideInteractorSingle(params: Unit?): Single<List<NewsEntity>> {
        return newsRepository.getNews()
            .map {
                it.sortedBy { list -> list.timestamp }
            }
    }
}
