package com.baktiyar11.cryptoapplication.di

import android.content.Context
import androidx.room.Room
import com.baktiyar11.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DB_NAME = "main.db"

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context, AppDatabase::class.java, DB_NAME
    ).build()

    @Provides
    @Singleton
    fun provideNewsDao(database: AppDatabase) = database.coinPriceInfoDao()
}