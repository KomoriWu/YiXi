package com.komori.yixi.di.component


import com.komori.yixi.application.MyApplication
import com.komori.yixi.di.module.AppModule

import javax.inject.Singleton

import dagger.Component

/**
 * Created by KomoriWu
 * on 2017-11-29.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    var context: MyApplication
}
