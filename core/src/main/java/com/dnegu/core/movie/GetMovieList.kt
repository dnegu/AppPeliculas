package com.dnegu.core.movie

import com.dnegu.core.common.Result

interface GetMovieList{
    suspend operator fun invoke(id: Int): Result<List<Movie>>
}

class GetMovieListImpl(private val movieRepository: MovieRepository): GetMovieList{
    override suspend fun invoke(id: Int): Result<List<Movie>> {
        return movieRepository.getMovieList(id)
    }
}