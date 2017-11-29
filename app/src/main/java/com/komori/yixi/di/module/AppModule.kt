package com.komori.yixi.di.module


import com.komori.yixi.application.MyApplication

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * Created by KomoriWu
 * on 2017-11-29.
 */

@Module
class AppModule(private val myApplication: MyApplication) {

    @Provides
    @Singleton
    fun provideMyApplication(): MyApplication {
        return myApplication
    }

}
