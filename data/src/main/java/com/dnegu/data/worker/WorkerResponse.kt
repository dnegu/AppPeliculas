package com.dnegu.data.worker

import com.dnegu.data.network.RoomMapper

data class WorkerResponse(
    val id: String,

    val name: String?,

    val lastName: String?
) : RoomMapper<WorkerEntity> {
    override fun mapToRoomEntity(): WorkerEntity {
        return WorkerEntity(id, name, lastName)
    }
}