package com.b2x.eurosport.presentation.mapper

import com.b2x.eurosport.domain.model.StoryEntity
import com.b2x.eurosport.presentation.model.Story

open class StoryViewModelMapper : ViewModelMapper<StoryEntity, Story> {

    override fun mapToViewModel(model: StoryEntity): Story {
        return Story(
            model.intro,
            model.content,
            model.author,
            model.timestamp,
            model.title,
            model.category,
            model.image
        )
    }
}
