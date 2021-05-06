package com.dnegu.apptemplate.di

import com.dnegu.apptemplate.ui.home.MovieListViewModel
import com.dnegu.apptemplate.ui.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { LoginViewModel(get(), get()) }
    viewModel { MovieListViewModel(get()) }
}