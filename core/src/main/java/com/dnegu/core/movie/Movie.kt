package com.dnegu.core.movie

import com.dnegu.core.common.TypeFactory
import com.dnegu.core.common.Visitable

data class Movie (
    val id:Int?=0,
    val poster_path:String?="",
    val original_title:String?="",
    val vote_average:Double?=0.0,
    val release_date:String?="",
    val overview:String?=""
):Visitable {
    override fun type(typeFactory: TypeFactory): Int {
        return typeFactory.type(this)
    }
}