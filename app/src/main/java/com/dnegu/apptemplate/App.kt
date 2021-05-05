package com.dnegu.apptemplate

import android.app.Application
import com.dnegu.apptemplate.di.appModule
import com.dnegu.apptemplate.di.presentationModule
import com.dnegu.core.di.interactionModule
import com.dnegu.data.di.databaseModule
import com.dnegu.data.di.networkModule
import com.dnegu.data.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    val coreModules = listOf(interactionModule)
    val dataModules = listOf(databaseModule, networkModule, repositoryModule)
    val appModules = listOf(presentationModule, appModule)

    override fun onCreate() {
        super.onCreate()
        startKoin {
            if (BuildConfig.DEBUG) androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(coreModules + dataModules + appModules)
        }
    }
}