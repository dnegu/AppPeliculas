package com.dnegu.apptemplate.common

import com.dnegu.apptemplate.R
import com.dnegu.core.common.TypeFactory
import com.dnegu.core.movie.Movie

class TypeFactoryImpl : TypeFactory {
    override fun type(item: Movie): Int {
        return R.layout.row_worker
    }
}