package com.dnegu.core.movie

import com.dnegu.core.common.Result

interface MovieRepository {
    suspend fun getMovieList(id: Int): Result<List<Movie>>

    suspend fun getMovieById(id: Int): Result<Movie>
}