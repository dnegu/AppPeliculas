package com.dnegu.core.di

import com.dnegu.core.login.Authenticate
import com.dnegu.core.login.AuthenticateImpl
import com.dnegu.core.movie.GetMovieList
import com.dnegu.core.movie.GetMovieListImpl
import org.koin.dsl.module

val interactionModule = module {

    factory<Authenticate> { AuthenticateImpl(get()) }

    factory<GetMovieList> { GetMovieListImpl(get()) }
}