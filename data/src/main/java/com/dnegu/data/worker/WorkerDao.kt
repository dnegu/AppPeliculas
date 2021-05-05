package com.dnegu.data.worker

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WorkerDao {

    @Query("select * from worker")
    suspend fun getWorkerList(): List<WorkerEntity>

    @Query("select * from worker where id = :id")
    suspend fun getWorkerById(id: Int): WorkerEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(workerEntity: WorkerEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMultiple(workerList: List<WorkerEntity>)
}