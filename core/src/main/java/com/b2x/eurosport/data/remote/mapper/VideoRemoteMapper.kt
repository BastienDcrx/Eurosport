package com.b2x.eurosport.data.remote.mapper

import com.b2x.eurosport.data.remote.model.VideoRemoteModel
import com.b2x.eurosport.domain.model.NewsEntity
import com.b2x.eurosport.domain.model.VideoEntity

open class VideoRemoteMapper : RemoteMapper<VideoRemoteModel, NewsEntity> {

    override fun mapToEntity(remoteModel: VideoRemoteModel): NewsEntity {
        return VideoEntity(
            remoteModel.url,
            remoteModel.views,
            remoteModel.timestamp,
            remoteModel.title,
            remoteModel.category,
            remoteModel.image
        )
    }
}
