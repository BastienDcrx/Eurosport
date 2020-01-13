package com.b2x.eurosport.presentation.di

import com.b2x.eurosport.BuildConfig
import com.b2x.eurosport.data.NewsDataSource
import com.b2x.eurosport.data.NewsRepositoryImpl
import com.b2x.eurosport.data.remote.EurosportServiceFactory
import com.b2x.eurosport.data.remote.NewsRemoteDataSource
import com.b2x.eurosport.data.remote.mapper.StoryRemoteMapper
import com.b2x.eurosport.data.remote.mapper.VideoRemoteMapper
import com.b2x.eurosport.domain.NewsRepository
import com.b2x.eurosport.domain.interactors.GetNewsInteractor
import com.b2x.eurosport.presentation.mapper.StoryViewModelMapper
import com.b2x.eurosport.presentation.mapper.VideoViewModelMapper
import com.b2x.eurosport.presentation.newsfeed.NewsFeedNewsViewModel
import com.b2x.eurosport.presentation.newsfeed.adapter.NewsAdapter
import com.b2x.eurosport.presentation.newsfeed.adapter.NewsItemTypeFactoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val REMOTE_DATASOURCE = "remote"

private const val COMPUTE_SCHEDULER = "compute"
private const val MAIN_SCHEDULER = "main"

val applicationModule = module(override = true) {

    single { EurosportServiceFactory.provideNewsService(BuildConfig.DEBUG) }

    factory { StoryRemoteMapper() }

    factory { VideoRemoteMapper() }

    factory<NewsDataSource>(named(REMOTE_DATASOURCE)) { NewsRemoteDataSource(get(), get(), get()) }

    single(named(COMPUTE_SCHEDULER)) { Schedulers.computation() }

    single(named(MAIN_SCHEDULER)) { AndroidSchedulers.mainThread() }

    factory<NewsRepository> { NewsRepositoryImpl(get(named(REMOTE_DATASOURCE))) }
}

private const val NEWS_ITEM_FACTORY = "news_factory"

val feedModule = module(override = true) {

    factory(named(NEWS_ITEM_FACTORY)) { NewsItemTypeFactoryImpl() }
    factory { NewsAdapter(get(named(NEWS_ITEM_FACTORY))) }

    factory {
        GetNewsInteractor(
            get(),
            get(named(COMPUTE_SCHEDULER)),
            get(named(MAIN_SCHEDULER))
        )
    }
    factory { StoryViewModelMapper() }
    factory { VideoViewModelMapper() }

    viewModel { NewsFeedNewsViewModel(get(), get(), get()) }
}
