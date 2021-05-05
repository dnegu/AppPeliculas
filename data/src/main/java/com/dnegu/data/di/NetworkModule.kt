package com.dnegu.data.di

import com.dnegu.data.BuildConfig
import com.dnegu.data.R
import com.dnegu.data.network.Api
import com.dnegu.data.network.AuthInterceptor
import com.dnegu.data.utils.LocalStorage
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { createHttpClient(get()) }
    single { createWebService<Api>(get(), androidContext().getString(R.string.api_url)) }
}

fun createHttpClient(localStorage: LocalStorage): OkHttpClient {
    val httpClientBuilder = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)

    if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClientBuilder.addInterceptor(loggingInterceptor)
    }

    httpClientBuilder.addInterceptor(AuthInterceptor(localStorage))

    return httpClientBuilder.build()
}

inline fun <reified T> createWebService(httpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(T::class.java)
}