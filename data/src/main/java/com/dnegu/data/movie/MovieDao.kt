package com.dnegu.data.movie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("select * from movie")
    suspend fun getMovieList(): List<MovieEntity>

    @Query("select * from movie where id = :id")
    suspend fun getMovieById(id: Int): MovieEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieEntity: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMultiple(movieList: List<MovieEntity>)
}