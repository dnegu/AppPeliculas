package com.dnegu.data.di

import androidx.room.Room
import com.dnegu.data.common.DB_NAME
import com.dnegu.data.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration().build()
    }

    single { get<AppDatabase>().workerDao() }
}