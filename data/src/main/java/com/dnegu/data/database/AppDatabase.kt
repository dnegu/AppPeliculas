package com.dnegu.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dnegu.data.movie.MovieDao
import com.dnegu.data.movie.MovieEntity

@Database(entities = [MovieEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}