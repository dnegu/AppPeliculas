package com.dnegu.core.common

import com.dnegu.core.movie.Movie

interface TypeFactory {
    fun type(item: Movie): Int
}