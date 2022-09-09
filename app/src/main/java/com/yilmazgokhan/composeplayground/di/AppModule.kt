package com.yilmazgokhan.composeplayground.di

import android.content.Context
import com.yilmazgokhan.composeplayground.PlaygroundApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): PlaygroundApp {
        return app as PlaygroundApp
    }
}