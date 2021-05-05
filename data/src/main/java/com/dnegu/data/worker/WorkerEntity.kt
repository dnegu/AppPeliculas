package com.dnegu.data.worker

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dnegu.core.worker.Worker
import com.dnegu.data.network.DomainMapper

@Entity(tableName = "worker")
data class WorkerEntity(
    @PrimaryKey
    val id: String,

    val name: String?,

    val lastName: String?
) : DomainMapper<Worker> {
    override fun mapToDomainModel(): Worker {
        return Worker(id, name, lastName)
    }
}