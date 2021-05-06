package com.dnegu.data.di

import com.dnegu.core.login.LoginRepository
import com.dnegu.core.movie.MovieRepository
import com.dnegu.data.login.LoginRepositoryImpl
import com.dnegu.data.movie.MovieRepositoryImpl
import com.dnegu.data.utils.LocalStorage
import com.dnegu.data.utils.NetworkUtils
import com.dnegu.data.utils.NetworkUtilsImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single { LocalStorage(androidContext()) }

    factory<NetworkUtils> { NetworkUtilsImpl(androidContext()) }

    factory<LoginRepository> { LoginRepositoryImpl(get()) }
    factory<MovieRepository> { MovieRepositoryImpl(get(), get()) }
}