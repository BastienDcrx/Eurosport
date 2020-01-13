package com.b2x.eurosport.presentation.mapper

import com.b2x.eurosport.domain.model.VideoEntity
import com.b2x.eurosport.presentation.model.Video

open class VideoViewModelMapper : ViewModelMapper<VideoEntity, Video> {

    override fun mapToViewModel(model: VideoEntity): Video {
        return Video(
            model.url,
            model.views,
            model.timestamp,
            model.title,
            model.category,
            model.image
        )
    }
}
