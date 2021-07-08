package com.dnegu.data.movie

import com.dnegu.data.network.RoomMapper

data class MovieResponse (
    val id:Int?=0,
    val poster_path:String?="",
    val original_title:String?="",
    val vote_average:Double?=0.0,
    val release_date:String?="",
    val overview:String?="",
    val original_language:String? = "",
    val adult:Boolean = false,
    val title: String? = "",
    val vote_count:String?=""
): RoomMapper<MovieEntity> {
    override fun mapToRoomEntity(): MovieEntity {
        return MovieEntity(id,
            "https://image.tmdb.org/t/p/w500/$poster_path",original_title,vote_average,release_date,overview,original_language,adult,title,vote_count)
    }
}