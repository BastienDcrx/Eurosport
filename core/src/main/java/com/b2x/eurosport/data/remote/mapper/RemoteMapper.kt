package com.b2x.eurosport.data.remote.mapper

interface RemoteMapper<R, E> {
    fun mapToEntity(remoteModel: R): E
}
