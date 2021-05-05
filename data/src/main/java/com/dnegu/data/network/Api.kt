package com.dnegu.data.network

import com.dnegu.data.login.LoginRequest
import com.dnegu.data.login.LoginResponse
import com.dnegu.data.worker.WorkerResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {

    @POST("auth")
    suspend fun authenticate(@Body request: LoginRequest): Response<LoginResponse>

    @GET("worker")
    suspend fun getWorkerList(): Response<List<WorkerResponse>>

    @GET("worker/{id}")
    suspend fun getWorkerById(@Path("id") id: Int): Response<WorkerResponse>
}