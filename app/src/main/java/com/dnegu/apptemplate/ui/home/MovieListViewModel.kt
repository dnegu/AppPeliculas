package com.dnegu.apptemplate.ui.home

import com.dnegu.apptemplate.common.BaseViewModel
import com.dnegu.apptemplate.common.Error
import com.dnegu.apptemplate.common.Success
import com.dnegu.core.common.onFailure
import com.dnegu.core.common.onSuccess
import com.dnegu.core.movie.GetMovieList
import com.dnegu.core.movie.Movie

class MovieListViewModel (private val getMovieList: GetMovieList):
    BaseViewModel<List<Movie>, Any>() {
        fun getAll(id: Int) = executeUseCase {
            getMovieList(id)
                .onSuccess { state.value = Success(it) }
                .onFailure { state.value = Error(it.throwable) }
        }
}