package com.b2x.eurosport.data.remote.mapper

import com.b2x.eurosport.data.remote.model.StoryRemoteModel
import com.b2x.eurosport.domain.model.NewsEntity
import com.b2x.eurosport.domain.model.StoryEntity

open class StoryRemoteMapper : RemoteMapper<StoryRemoteModel, NewsEntity> {

    override fun mapToEntity(remoteModel: StoryRemoteModel): NewsEntity {
        return StoryEntity(
            remoteModel.intro,
            remoteModel.content,
            remoteModel.author,
            remoteModel.timestamp,
            remoteModel.title,
            remoteModel.category,
            remoteModel.image
        )
    }
}
