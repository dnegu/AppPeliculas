package com.dnegu.data.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dnegu.core.movie.Movie
import com.dnegu.data.network.DomainMapper

@Entity(tableName = "movie")
data class MovieEntity (
    @PrimaryKey
    val id: Int?=0,
    val poster_path:String?="",
    val original_title:String?="",
    val vote_average:Double?=0.0,
    val release_date:String?="",
    val overview:String?=""
) : DomainMapper<Movie> {
    override fun mapToDomainModel(): Movie {
        return Movie(id, poster_path,original_title,vote_average,release_date,overview)
    }
}