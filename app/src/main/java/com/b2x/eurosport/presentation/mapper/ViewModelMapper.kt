package com.b2x.eurosport.presentation.mapper

interface ViewModelMapper<in E, out VM> {
    fun mapToViewModel(model: E): VM
}
