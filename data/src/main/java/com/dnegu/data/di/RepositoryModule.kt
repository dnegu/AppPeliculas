package com.dnegu.data.di

import com.dnegu.core.login.LoginRepository
import com.dnegu.core.worker.WorkerRepository
import com.dnegu.data.login.LoginRepositoryImpl
import com.dnegu.data.utils.LocalStorage
import com.dnegu.data.utils.NetworkUtils
import com.dnegu.data.utils.NetworkUtilsImpl
import com.dnegu.data.worker.WorkerRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single { LocalStorage(androidContext()) }

    factory<NetworkUtils> { NetworkUtilsImpl(androidContext()) }

    factory<LoginRepository> { LoginRepositoryImpl(get()) }
    factory<WorkerRepository> { WorkerRepositoryImpl(get(), get()) }
}