package com.dnegu.core.di

import com.dnegu.core.login.Authenticate
import com.dnegu.core.login.AuthenticateImpl
import com.dnegu.core.worker.GetWorker
import com.dnegu.core.worker.GetWorkerImpl
import com.dnegu.core.worker.GetWorkerList
import com.dnegu.core.worker.GetWorkerListImpl
import org.koin.dsl.module

val interactionModule = module {

    factory<Authenticate> { AuthenticateImpl(get()) }

    factory<GetWorker> { GetWorkerImpl(get()) }
    factory<GetWorkerList> { GetWorkerListImpl(get()) }
}