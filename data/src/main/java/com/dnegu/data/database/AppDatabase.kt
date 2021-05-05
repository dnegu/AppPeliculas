package com.dnegu.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dnegu.data.worker.WorkerDao
import com.dnegu.data.worker.WorkerEntity

@Database(entities = [WorkerEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun workerDao(): WorkerDao
}