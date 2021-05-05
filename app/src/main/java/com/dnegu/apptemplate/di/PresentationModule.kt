package com.dnegu.apptemplate.di

import com.dnegu.apptemplate.ui.home.WorkerListViewModel
import com.dnegu.apptemplate.ui.home.WorkerViewModel
import com.dnegu.apptemplate.ui.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { LoginViewModel(get(), get()) }
    viewModel { WorkerViewModel(get()) }
    viewModel { WorkerListViewModel(get()) }
}