package com.dnegu.data.network

import com.dnegu.data.login.LoginRequest
import com.dnegu.data.login.LoginResponse
import com.dnegu.data.movie.ApiResponse
import com.dnegu.data.movie.MovieResponse
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @POST("auth")
    suspend fun authenticate(@Body request: LoginRequest): Response<LoginResponse>

    @GET("upcoming")
    suspend fun getMovieList(@Query("page") page: Int,
                             @Query("api_key") api_key: String): Response<ApiResponse<MovieResponse>>

    @GET("worker/{id}")
    suspend fun getMovieById(@Path("id") id: Int): Response<MovieResponse>
}