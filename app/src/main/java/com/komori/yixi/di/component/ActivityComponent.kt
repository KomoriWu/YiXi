package com.komori.yixi.di.component

import android.app.Activity

import com.komori.yixi.main.MainActivity
import com.komori.yixi.di.module.ActivityModule
import com.komori.yixi.di.scope.ActivityScope

import dagger.Component

/**
 * Created by KomoriWu
 * on 2017-11-29.
 */

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    val activity: Activity
    fun inject(mainActivity: MainActivity)
}
